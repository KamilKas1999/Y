package com.kasprzak.kamil.demoapp.demoapp.user.dto;

import com.kasprzak.kamil.demoapp.demoapp.user.User;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class UsersDTO {

    private List<User> users;
}
