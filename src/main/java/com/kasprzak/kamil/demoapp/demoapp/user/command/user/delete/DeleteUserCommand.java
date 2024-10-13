package com.kasprzak.kamil.demoapp.demoapp.user.command.user.delete;

import com.kasprzak.kamil.demoapp.demoapp.common.command.Command;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DeleteUserCommand implements Command {

      private long id;
}
