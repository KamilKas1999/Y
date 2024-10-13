package com.kasprzak.kamil.demoapp.demoapp.user;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DefaultUserService implements UserService {

    private final UserRepository userRepository;


    public void createUser(final String name, final String username) {
        final User user = new User(name, username);
        userRepository.save(user);
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }
}
