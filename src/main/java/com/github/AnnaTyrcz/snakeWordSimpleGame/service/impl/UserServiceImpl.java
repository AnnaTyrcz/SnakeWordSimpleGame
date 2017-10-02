package com.github.AnnaTyrcz.snakeWordSimpleGame.service.impl;

import com.github.AnnaTyrcz.snakeWordSimpleGame.model.User;
import com.github.AnnaTyrcz.snakeWordSimpleGame.repository.UserRepository;
import com.github.AnnaTyrcz.snakeWordSimpleGame.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User addUser(User user) {
        if (user.getId() == null) {
            userRepository.save(user);
        }
        return null;
    }
}
