package com.kasprzak.kamil.demoapp.user;

import lombok.Builder;

import java.util.List;

@Builder
public record UsersDTO(
        List<UserDTO> users
) {
}
