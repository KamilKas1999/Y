package com.kasprzak.kamil.demoapp.demoapp.user;

import java.util.List;

public interface UserService {


    void createUser(final String name, final String username);

    List<User> getUsers();


    void deleteUser(long id);
}
