package com.cloudgate.model;
import jakarta.persistence.*;
import java.time.Instant;
@Entity @Table(name = "tokens")
public class AuthToken {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    private Long userId; private String token; private Instant expiresAt;
    public Long getId() { return id; } public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
    public String getToken() { return token; } public void setToken(String token) { this.token = token; }
    public Instant getExpiresAt() { return expiresAt; } public void setExpiresAt(Instant expiresAt) { this.expiresAt = expiresAt; }
}
 
