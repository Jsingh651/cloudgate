package com.cloudgate.service;
import com.cloudgate.dto.LoginRequest;
import com.cloudgate.dto.LoginResponse;
import com.cloudgate.dto.UserDto;
import com.cloudgate.model.AuthToken;
import com.cloudgate.model.User;
import com.cloudgate.repository.AuthTokenRepository;
import com.cloudgate.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.time.Instant;
import java.util.UUID;
@Service
