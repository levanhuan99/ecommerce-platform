package com.ecommerce.user_service.controller;


import ecommerce.jwt.JwtUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @GetMapping("/health")
    public String healthCheck() {
        return "Check healthy";
    }

    @PostMapping("/sign-up")
    public String signUp(@RequestBody User user) {
        return "Sign-up a new user successfully!!";
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody User user) {
        final String token = JwtUtil.generateToken(user.getUsername());
        AuthResponse AuthResponse = new AuthResponse(token, JwtUtil.getExpiredTimeMillisecond());
        return  ResponseEntity.accepted().body(AuthResponse);
    }

    @GetMapping("/info")
    public ResponseEntity<User> healthCheck(@RequestParam(value = "userName") String userName) {
        final User user = new User("huan", "123", "huan@gmail.com");
        return ResponseEntity.accepted().body(user);
    }
}

class AuthResponse {
    private String token;
    private long expiredTime;
    public AuthResponse(String token, long expiredTime) {
        this.token = token;
        this.expiredTime = expiredTime;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public long getExpiredTime() {
        return expiredTime;
    }

    public void setExpiredTime(long expiredTime) {
        this.expiredTime = expiredTime;
    }
}

