package com.nmb.movieapi.controller;

import com.nmb.movieapi.model.User;
import com.nmb.movieapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/register")
    public User register(@RequestParam String username, @RequestParam String password, @RequestParam String email) {
        return userService.registerUser(username, password, email);
    }

    @PostMapping("/login")
    public User login(@RequestParam String username, @RequestParam String password) {
        return userService.loginUser(username, password);
    }

    @PostMapping("/update-avatar")
    public User updateAvatar(@RequestParam String username, @RequestParam String avatarUri) {
        return userService.updateAvatar(username, avatarUri);
    }

    @PostMapping("/add-credit-card")
    public User addCreditCard(@RequestParam String username, @RequestParam String number, @RequestParam String expiryDate, @RequestParam String cvv) {
        return userService.addCreditCard(username, number, expiryDate, cvv);
    }

    @PostMapping("/remove-credit-card")
    public User removeCreditCard(@RequestParam String username) {
        return userService.removeCreditCard(username);
    }
}