package com.eray.jwt.security.service;


import com.eray.jwt.security.dto.UserDto;
import com.eray.jwt.security.exception.GenericException;
import com.eray.jwt.security.model.User;
import com.eray.jwt.security.repository.UserRepository;
import lombok.val;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserDto createUser(User user)  {
        User newUser = new User(user.getId(), user.getUsername(), passwordEncoder.encode(user.getPassword()), user.getEmail(), user.getRole());
        val savedUser = userRepository.save(newUser);
        return new UserDto(savedUser.getUsername(), passwordEncoder.encode(user.getPassword()), user.getEmail(), user.getRole());
    }

    public UserDto getUser(String username)  {
        val savedUser = userRepository.findByUsername(username);
        if (savedUser.isPresent())
            return new UserDto(savedUser.get().getUsername(), passwordEncoder.encode(savedUser.get().getPassword()),
                    savedUser.get().getEmail(), savedUser.get().getRole());
        else
            throw new GenericException(HttpStatus.NOT_FOUND, "User not found by given username");
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(() -> new GenericException(HttpStatus.NOT_FOUND,"user not found by given id"));
    }
}
