package com.kasprzak.kamil.demoapp.user;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DefaultUserService implements UserService {

    private final UserRepository userRepository;


    public void createUser(final String name, final String username) {
        final UserEntity userEntity = UserEntity.builder().firstname(name).lastname(username).build();
        userRepository.save(userEntity);
    }

    public List<UserEntity> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }
}
