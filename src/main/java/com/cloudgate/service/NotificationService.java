package com.cloudgate.service;
import com.cloudgate.dto.NotificationDto;
import com.cloudgate.model.Notification;
import com.cloudgate.repository.NotificationRepository;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class NotificationService {
    private final NotificationRepository repo;
    public NotificationService(NotificationRepository repo) { this.repo = repo; }
    public List<NotificationDto> forUser(Long userId) {
        return repo.findByUserIdOrderByCreatedAtDesc(userId).stream()
            .map(n -> new NotificationDto(n.getId(), n.getTitle(), n.getBody(), n.isRead(), n.getCreatedAt())).toList();
    }
    public NotificationDto send(Long userId, String title, String body) {
        Notification n = new Notification(); n.setUserId(userId); n.setTitle(title); n.setBody(body); n = repo.save(n);
        return new NotificationDto(n.getId(), n.getTitle(), n.getBody(), n.isRead(), n.getCreatedAt());
    }
}

