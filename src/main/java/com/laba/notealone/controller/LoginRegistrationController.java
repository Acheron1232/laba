package com.laba.notealone.controller;

import com.laba.notealone.config.JwtTokenUtil;
import com.laba.notealone.dto.AuthDtoLogin;
import com.laba.notealone.dto.UserRegistrationDto;
import com.laba.notealone.entity.Role;
import com.laba.notealone.entity.User;
import com.laba.notealone.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class LoginRegistrationController {
    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtil jwtTokenUtil;


    @PostMapping("/registration")
    public String registration(@RequestBody UserRegistrationDto user) {
        userService.save(new User(null, user.getEmail(), user.getPassword(), user.getFirst_name(), user.getLast_name(), LocalDateTime.now(), null, Role.USER));
        return "Successful";
    }

    @PostMapping("/token")
    public ResponseEntity<?> registration(@RequestBody AuthDtoLogin authentication) {
        Optional<User> byEmail = userService.findByEmail(authentication.getEmail());
        System.out.println(byEmail);
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authentication.getEmail(), authentication.getPassword()));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.ok("");
        }
        UserDetails userDetails = userService.loadUserByUsername(authentication.getEmail());
        return ResponseEntity.ok(jwtTokenUtil.generateToken(userDetails));
    }

    @GetMapping("/token")
    public String registration() {
        return "sad";
    }

}
