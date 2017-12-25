package com.github.AnnaTyrcz.SnakeWordSimpleGame.service.impl;

import com.github.AnnaTyrcz.SnakeWordSimpleGame.model.User;
import com.github.AnnaTyrcz.SnakeWordSimpleGame.repository.UserRepository;
import com.github.AnnaTyrcz.SnakeWordSimpleGame.service.UserService;
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
