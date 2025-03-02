package com.kasprzak.kamil.demoapp.user;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DefaultUserService implements UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Override
    public UserEntity getUsersById(long id) {
        return userRepository.findById(id).orElseThrow();
    }

    public Long createUser(final String name, final String lastName, final String email,
                           final String password, final Role role) {
//        final UserEntity userEntity = UserEntity.builder().firstname(name).lastname(username).build();
//        userRepository.save(userEntity);
        var user = UserEntity.builder()
                .firstname(name)
                .lastname(lastName)
                .email(email)
                .password(passwordEncoder.encode(password))
                .role(role)
                .build();
        return userRepository.save(user).getId();
    }

    public List<UserEntity> getUsers() {
        return userRepository.findAll();
    }



    @Override
    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }
}
