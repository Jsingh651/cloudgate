package com.cloudgate.model;
import jakarta.persistence.*;
import java.time.Instant;
@Entity @Table(name = "notifications")
public class Notification {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    private Long userId; private String title; private String body; private boolean read = false;
    private Instant createdAt = Instant.now();
