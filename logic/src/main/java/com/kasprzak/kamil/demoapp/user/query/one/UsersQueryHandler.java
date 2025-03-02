package com.kasprzak.kamil.demoapp.user.query.one;

import com.kasprzak.kamil.demoapp.common.query.QueryHandler;
import com.kasprzak.kamil.demoapp.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UsersQueryHandler implements QueryHandler<UsersQuery, UsersQueryResult> {

    private final UserService userService;

    public UsersQueryResult handle(UsersQuery query) {
        var user = userService.getUsersById(query.userId());
        return UsersQueryResult.builder()
                .userEntities(user)
                .build();
    }

}
