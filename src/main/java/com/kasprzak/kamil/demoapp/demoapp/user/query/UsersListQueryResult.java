package com.kasprzak.kamil.demoapp.demoapp.user.query;

import com.kasprzak.kamil.demoapp.demoapp.common.query.QueryResult;
import com.kasprzak.kamil.demoapp.demoapp.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Builder
@Data
public class UsersListQueryResult implements QueryResult {

    List<User> users;
}
