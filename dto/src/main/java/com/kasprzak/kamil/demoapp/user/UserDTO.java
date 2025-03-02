package com.kasprzak.kamil.demoapp.user;

import lombok.Builder;

@Builder
public record UserDTO(
        Long id,
        String firstname,
        String lastname,
        String email
) {

}
