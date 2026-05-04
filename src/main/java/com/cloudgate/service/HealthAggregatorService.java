package com.cloudgate.service;
import com.cloudgate.dto.ServiceHealthDto;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class HealthAggregatorService {
    public List<ServiceHealthDto> checkAll() {
        return List.of(
            new ServiceHealthDto("auth", "UP", 12),
            new ServiceHealthDto("users", "UP", 8),
            new ServiceHealthDto("notifications", "UP", 15)
        );
    }
}
