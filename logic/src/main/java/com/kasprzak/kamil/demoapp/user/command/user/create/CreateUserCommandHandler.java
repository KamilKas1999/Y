package com.kasprzak.kamil.demoapp.user.command.user.create;

import com.kasprzak.kamil.demoapp.common.command.CommandHandler;
import com.kasprzak.kamil.demoapp.common.command.CommandHandlerWithResult;
import com.kasprzak.kamil.demoapp.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CreateUserCommandHandler implements CommandHandlerWithResult<CreateUserCommand, CreateUserCommandResult> {

    private final UserService userService;

    @Override
    public CreateUserCommandResult handle(final CreateUserCommand command) {
        var userdId = userService.createUser(command.getFirstname(), command.getLastname(),
                command.getEmail(), command.getPassword(), command.getRole());
        return new CreateUserCommandResult(userdId);
    }
}
