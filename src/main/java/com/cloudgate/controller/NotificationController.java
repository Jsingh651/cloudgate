package com.cloudgate.controller;
import com.cloudgate.service.NotificationService;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
@RestController @RequestMapping("/api/notifications")
public class NotificationController {
    private final NotificationService notifications;
    public NotificationController(NotificationService n) { this.notifications = n; }
    @GetMapping("/{userId}") public Object list(@PathVariable Long userId) { return notifications.forUser(userId); }
    @PostMapping public Object send(@RequestBody Map<String, String> body) {
        return notifications.send(Long.parseLong(body.get("userId")), body.get("title"), body.get("body"));
    }
}
