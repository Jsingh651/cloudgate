package com.cloudgate.service;
import com.cloudgate.dto.LoginRequest;
import com.cloudgate.dto.LoginResponse;
import com.cloudgate.dto.UserDto;
import com.cloudgate.model.AuthToken;
import com.cloudgate.model.User;
import com.cloudgate.repository.AuthTokenRepository;
import com.cloudgate.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.time.Instant;
import java.util.UUID;
@Service
public class AuthService {
    private final UserRepository users; private final AuthTokenRepository tokens;
    public AuthService(UserRepository users, AuthTokenRepository tokens) { this.users = users; this.tokens = tokens; }
    public LoginResponse login(LoginRequest req) {
        User user = users.findByEmail(req.email()).orElseThrow(() -> new RuntimeException("Invalid credentials"));
        String token = UUID.randomUUID().toString();
        AuthToken at = new AuthToken(); at.setUserId(user.getId()); at.setToken(token); at.setExpiresAt(Instant.now().plusSeconds(3600));
        tokens.save(at);
        return new LoginResponse(token, new UserDto(user.getId(), user.getEmail(), user.getName(), user.getRole(), user.isActive()));
    }
}
 
