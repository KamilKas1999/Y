package com.kasprzak.kamil.demoapp.auth.event;

import java.io.Serializable;

public class UserLoggedEvent implements Serializable {
    private Long userId;

    public UserLoggedEvent() {}

    public UserLoggedEvent(Long userId) {
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }
}
