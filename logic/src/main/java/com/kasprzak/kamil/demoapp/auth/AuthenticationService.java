package com.kasprzak.kamil.demoapp.auth;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kasprzak.kamil.demoapp.auth.event.NewUserRegisteredEvent;
import com.kasprzak.kamil.demoapp.common.command.CommandExecutor;
import com.kasprzak.kamil.demoapp.common.kafka.producer.KafkaProducer;
import com.kasprzak.kamil.demoapp.common.query.QueryExecutor;
import com.kasprzak.kamil.demoapp.security.JwtService;
import com.kasprzak.kamil.demoapp.token.Token;
import com.kasprzak.kamil.demoapp.token.TokenRepository;
import com.kasprzak.kamil.demoapp.token.TokenType;
import com.kasprzak.kamil.demoapp.user.UserEntity;
import com.kasprzak.kamil.demoapp.user.UserRepository;
import com.kasprzak.kamil.demoapp.user.command.user.create.CreateUserCommand;
import com.kasprzak.kamil.demoapp.user.command.user.create.CreateUserCommandResult;
import com.kasprzak.kamil.demoapp.user.query.one.UsersQuery;
import com.kasprzak.kamil.demoapp.user.query.one.UsersQueryResult;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository repository;
    private final TokenRepository tokenRepository;
    //    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    private final CommandExecutor commandExecutor;
    private final QueryExecutor queryExecutor;

    private final KafkaProducer kafkaProducer;

    public AuthenticationResponse register(RegisterRequest request) {
//        var user = UserEntity.builder()
//                .firstname(request.getFirstname())
//                .lastname(request.getLastname())
//                .email(request.getEmail())
//                .password(passwordEncoder.encode(request.getPassword()))
//                .role(request.getRole())
//                .build();
//        var savedUser = repository.save(user);
        var command = new CreateUserCommand(request.getFirstname(), request.getLastname(), request.getEmail(),
                request.getPassword(), request.getRole());
        var commandResult = commandExecutor.execute(command, CreateUserCommandResult.class);
        var query = new UsersQuery(commandResult.userId());
        var user = queryExecutor.execute(query, UsersQueryResult.class);

        var jwtToken = jwtService.generateToken(user.getUserEntities());
        var refreshToken = jwtService.generateRefreshToken(user.getUserEntities());
        saveUserToken(user.getUserEntities(), jwtToken);
        kafkaProducer.sendEvent(new NewUserRegisteredEvent(user.getUserEntities().getId()));
        return AuthenticationResponse.builder()
                .accessToken(jwtToken)
                .refreshToken(refreshToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.email(),
                        request.password()
                )
        );
        var user = repository.findByEmail(request.email())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        var refreshToken = jwtService.generateRefreshToken(user);
        revokeAllUserTokens(user);
        saveUserToken(user, jwtToken);
        return AuthenticationResponse.builder()
                .accessToken(jwtToken)
                .refreshToken(refreshToken)
                .build();
    }

    private void saveUserToken(UserEntity userEntity, String jwtToken) {
        var token = Token.builder()
                .userEntity(userEntity)
                .token(jwtToken)
                .tokenType(TokenType.BEARER)
                .expired(false)
                .revoked(false)
                .build();
        tokenRepository.save(token);
    }

    private void revokeAllUserTokens(UserEntity userEntity) {
        var validUserTokens = tokenRepository.findAllValidTokenByUser(userEntity.getId());
        if (validUserTokens.isEmpty())
            return;
        validUserTokens.forEach(token -> {
            token.setExpired(true);
            token.setRevoked(true);
        });
        tokenRepository.saveAll(validUserTokens);
    }

    public void refreshToken(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException {
        final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        final String refreshToken;
        final String userEmail;
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return;
        }
        refreshToken = authHeader.substring(7);
        userEmail = jwtService.extractUsername(refreshToken);
        if (userEmail != null) {
            var user = this.repository.findByEmail(userEmail)
                    .orElseThrow();
            if (jwtService.isTokenValid(refreshToken, user)) {
                var accessToken = jwtService.generateToken(user);
                revokeAllUserTokens(user);
                saveUserToken(user, accessToken);
                var authResponse = AuthenticationResponse.builder()
                        .accessToken(accessToken)
                        .refreshToken(refreshToken)
                        .build();
                new ObjectMapper().writeValue(response.getOutputStream(), authResponse);
            }
        }
    }
}
