package com.kasprzak.kamil.demoapp.demoapp.user.query;

import com.kasprzak.kamil.demoapp.demoapp.common.query.QueryHandler;
import com.kasprzak.kamil.demoapp.demoapp.user.User;
import com.kasprzak.kamil.demoapp.demoapp.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UsersListQueryHandler implements QueryHandler<UsersListQuery,UsersListQueryResult> {

    private final UserService userService;

    public UsersListQueryResult handle(UsersListQuery query){
        var users =  userService.getUsers();
        return UsersListQueryResult.builder()
                .users(users)
                .build();
    }

}
