package com.url.url_shortner_sb.controller;


import com.url.url_shortner_sb.dtos.LoginRequest;
import com.url.url_shortner_sb.dtos.RegisterRequest;
import com.url.url_shortner_sb.models.User;
import com.url.url_shortner_sb.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/auth/")
public class AuthController {

    @Autowired
    private UserService userService;


    @PostMapping("/public/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginRequest loginRequest){
      // log.info("loginRequest:{}", loginRequest);
        return ResponseEntity.ok(userService.authenticateUser(loginRequest));
    }



    @PostMapping("/public/register")
    public ResponseEntity<?> registerUser(@RequestBody RegisterRequest registerRequest){
        User user = new User();
        user.setUsername(registerRequest.getUsername());
        user.setPassword(registerRequest.getPassword());
        user.setEmail(registerRequest.getEmail());
        user.setRole("ROLE_USER");
        userService.registerUser(user);
        return ResponseEntity.ok("User registration successfully");
    }
}
