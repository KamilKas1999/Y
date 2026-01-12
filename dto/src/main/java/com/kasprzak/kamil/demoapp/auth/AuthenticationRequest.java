package com.kasprzak.kamil.demoapp.auth;

import lombok.Builder;

@Builder
public record AuthenticationRequest(
        String email,
        String password
) {
}
