package com.example.Greeting.controller;

import com.example.Greeting.dto.AuthUserDTO;
import com.example.Greeting.dto.JwtResponseDTO;
import com.example.Greeting.dto.LoginDTO;
import com.example.Greeting.service.AuthenticationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
import java.util.HashMap;


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

    //UC-12 Forgot Password Implementation
    @PutMapping("/forgotPassword/{email}")
    public ResponseEntity<Map<String, String>> forgotPassword(@PathVariable String email, @RequestBody Map<String, String> requestBody) {
        String newPassword = requestBody.get("password");
        authenticationService.forgotPassword(email, newPassword);

        Map<String, String> response = new HashMap<>();
        response.put("message", "Password has been changed successfully!");

        return ResponseEntity.ok(response);
    }
    //First register a user then give its email id in forget password and then new email id got set
    //curl -X PUT "http://localhost:8080/auth/forgotPassword/user@example.com" \
    //     -H "Content-Type: application/json" \
    //     -d '{"password": "NewStrong@123"}'
    //Output -{
    //  "message": "Password has been changed successfully!"
    //}
    //We acn check in db also 

    //UC-13 Reset Password
    @PutMapping("/resetPassword/{email}")
    public ResponseEntity<String> resetPassword(
            @PathVariable String email,
            @RequestBody Map<String, String> requestBody) {

        String currentPassword = requestBody.get("currentPassword");
        String newPassword = requestBody.get("newPassword");

        if (currentPassword == null || newPassword == null) {
            return ResponseEntity.badRequest().body("Both current and new passwords are required!");
        }

        return ResponseEntity.ok(authenticationService.resetPassword(email, currentPassword, newPassword));
    }
    //curl -X PUT "http://localhost:8080/auth/resetPassword/john@example.com" \
    //     -H "Content-Type: application/json" \
    //     -d '{
    //           "currentPassword": "OldPassword@123",
    //           "newPassword": "NewStrong@123"
    //         }'

}
