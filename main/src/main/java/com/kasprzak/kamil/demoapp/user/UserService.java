package com.kasprzak.kamil.demoapp.user;

import java.util.List;

public interface UserService {


    void createUser(final String name, final String username);

    List<UserEntity> getUsers();


    void deleteUser(long id);
}
