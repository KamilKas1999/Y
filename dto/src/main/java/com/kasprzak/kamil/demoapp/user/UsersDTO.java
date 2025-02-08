package com.kasprzak.kamil.demoapp.user;

import com.kasprzak.kamil.demoapp.user.UserEntity;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class UsersDTO {

    private List<UserEntity> userEntities;
}
