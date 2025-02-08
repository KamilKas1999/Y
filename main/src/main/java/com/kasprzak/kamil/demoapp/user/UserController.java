package com.kasprzak.kamil.demoapp.user;

import com.kasprzak.kamil.demoapp.common.command.CommandExecutor;
import com.kasprzak.kamil.demoapp.common.query.QueryExecutor;
import com.kasprzak.kamil.demoapp.user.command.user.delete.DeleteUserCommand;
import com.kasprzak.kamil.demoapp.user.query.UsersListQuery;
import com.kasprzak.kamil.demoapp.user.query.UsersListQueryResult;
import com.kasprzak.kamil.demoapp.user.dto.DeleteUserDTO;
import com.kasprzak.kamil.demoapp.user.dto.UsersDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private QueryExecutor queryExecutor;

    @Autowired
    private CommandExecutor commandExecutor;

//    @PostMapping
//    public void createUser(final CreateUserDTO userDTO) {
//        final var command = new CreateUserCommand(userDTO.getName(), userDTO.getUsername());
//        commandExecutor.execute(command);
//    }

    @GetMapping
    public UsersDTO getUsers() {
        var query = new UsersListQuery();
        var result = queryExecutor.execute(query, UsersListQueryResult.class);
        return UsersDTO
                .builder()
                .userEntities(result.getUserEntities())
                .build();
    }

    @DeleteMapping
    public void deleteUser(final DeleteUserDTO userDTO) {
        var command = new DeleteUserCommand(userDTO.getUserId());
        commandExecutor.execute(command);
    }
}
