package com.example.Greeting.controller;

import com.example.Greeting.dto.AuthUserDTO;
import com.example.Greeting.dto.JwtResponseDTO;
import com.example.Greeting.dto.LoginDTO;
import com.example.Greeting.service.AuthenticationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthUserController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@Valid @RequestBody AuthUserDTO authUserDTO) {
        return ResponseEntity.status(201).body(authenticationService.register(authUserDTO));
    }

    @PostMapping("/login")
    public ResponseEntity<JwtResponseDTO> login(@Valid @RequestBody LoginDTO loginDTO) {
        return ResponseEntity.ok(authenticationService.login(loginDTO));
    }
}
