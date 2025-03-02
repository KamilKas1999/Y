package com.kasprzak.kamil.demoapp.auth.event;

import org.springframework.stereotype.Component;

import java.io.Serializable;

public class NewUserRegisteredEvent implements Serializable {
    private Long userId;

    public NewUserRegisteredEvent() {}

    public NewUserRegisteredEvent(Long userId) {
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }
}
