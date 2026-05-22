package com.cloudgate.service;
import com.cloudgate.dto.UserDto;
import com.cloudgate.model.User;
import com.cloudgate.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class UserService {
    private final UserRepository repo;
    public UserService(UserRepository repo) { this.repo = repo; }
    public List<UserDto> list() { return repo.findAll().stream().map(u -> new UserDto(u.getId(), u.getEmail(), u.getName(), u.getRole(), u.isActive())).toList(); }
    public UserDto create(String email, String name) {
        User u = new User(); u.setEmail(email); u.setName(name); u = repo.save(u);
        return new UserDto(u.getId(), u.getEmail(), u.getName(), u.getRole(), u.isActive());
    }
}
