package com.kasprzak.kamil.demoapp.user;

import java.util.List;

public interface UserService {


    Long createUser(final String name, final String lastName, final String email,
                    final String password, final Role role);

    List<UserEntity> getUsers();
    UserEntity getUsersById(long id);


    void deleteUser(long id);
}
