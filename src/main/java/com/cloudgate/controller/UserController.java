package com.cloudgate.controller;
import com.cloudgate.service.UserService;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
@RestController @RequestMapping("/api/users")
public class UserController {
    private final UserService users;
    public UserController(UserService users) { this.users = users; }
    @GetMapping public Object list() { return users.list(); }
    @PostMapping public Object create(@RequestBody Map<String, String> body) { return users.create(body.get("email"), body.get("name")); }
}
 
