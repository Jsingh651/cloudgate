package com.cloudgate.dto;
import java.time.Instant;
public record NotificationDto(Long id, String title, String body, boolean read, Instant createdAt) {}
