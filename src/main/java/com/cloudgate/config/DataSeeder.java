package com.cloudgate.config;
import com.cloudgate.model.Notification;
import com.cloudgate.model.User;
import com.cloudgate.repository.NotificationRepository;
import com.cloudgate.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class DataSeeder {
    @Bean CommandLineRunner seed(UserRepository users, NotificationRepository notifications) {
        return args -> {
            if (users.count() > 0) return;
            User admin = new User(); admin.setEmail("admin@cloudgate.local"); admin.setName("Admin"); admin.setRole("ADMIN");
            admin = users.save(admin);
            Notification n = new Notification(); n.setUserId(admin.getId()); n.setTitle("Welcome"); n.setBody("CloudGate is ready.");
            notifications.save(n);
        };
    }
}

