package com.eray.jwt.security.service;

import com.eray.jwt.security.dto.UserDto;
import com.eray.jwt.security.model.User;
import com.eray.jwt.security.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDto createUser(String username)  {


    }
}
