package com.kasprzak.kamil.demoapp.user.command.user.create;

import com.kasprzak.kamil.demoapp.user.UserService;
import com.kasprzak.kamil.demoapp.common.command.CommandHandler;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CreateUserCommandHandler implements CommandHandler<CreateUserCommand> {

    private final UserService userService;

    @Override
    public void handle(CreateUserCommand command) {
        userService.createUser(command.getName(), command.getUsername());
    }
}
