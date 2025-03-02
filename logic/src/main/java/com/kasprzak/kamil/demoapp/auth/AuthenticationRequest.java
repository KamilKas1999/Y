package com.kasprzak.kamil.demoapp.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
public record AuthenticationRequest(
        String email,
        String password
) {
}
