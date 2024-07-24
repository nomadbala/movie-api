package com.nmb.movieapi.service;

import com.nmb.movieapi.model.User;
import com.nmb.movieapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class UserService {
    private final UserRepository userRepository;

    public User registerUser(String username, String password, String email) {
        User existingUser = userRepository.findByUsername(username);
        if (existingUser != null) {
            throw new RuntimeException("User already registered");
        }
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        return userRepository.save(user);
    }

    public User loginUser(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user == null || !user.getPassword().equals(password)) {
            throw new RuntimeException("Invalid username or password");
        }
        return user;
    }

    public User updateAvatar(String username, String avatarUri) {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new RuntimeException("User not found");
        }
        user.setAvatarUri(avatarUri);
        return userRepository.save(user);
    }

    public User addCreditCard(String username, String number, String expiryDate, String cvv) {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new RuntimeException("User not found");
        }
        user.setCreditCardNumber(number);
        user.setCreditCardExpiryDate(expiryDate);
        user.setCreditCardCvv(cvv);
        return userRepository.save(user);
    }

    public User removeCreditCard(String username) {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new RuntimeException("User not found");
        }
        user.setCreditCardNumber(null);
        user.setCreditCardExpiryDate(null);
        user.setCreditCardCvv(null);
        return userRepository.save(user);
    }
}