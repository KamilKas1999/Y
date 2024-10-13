package com.kasprzak.kamil.demoapp.demoapp.user.command.user.create;

import com.kasprzak.kamil.demoapp.demoapp.common.command.Command;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateUserCommand implements Command {

    private String name;
    private String username;
}
