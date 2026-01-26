package com.cloudgate.controller;
import com.cloudgate.service.HealthAggregatorService;
import org.springframework.web.bind.annotation.*;
@RestController @RequestMapping("/api/health")
public class HealthController {
    private final HealthAggregatorService health;
    public HealthController(HealthAggregatorService health) { this.health = health; }
    @GetMapping public Object check() { return health.checkAll(); }
}


 
