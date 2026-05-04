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
