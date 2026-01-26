package com.cloudgate.controller;
import com.cloudgate.dto.LoginRequest;
import com.cloudgate.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
@RestController @RequestMapping("/api/auth")
public class AuthController {
    private final AuthService auth;
    public AuthController(AuthService auth) { this.auth = auth; }
    @PostMapping("/login") public Object login(@Valid @RequestBody LoginRequest req) { return auth.login(req); }
}
