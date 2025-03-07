package com.example.Greeting.service;

import com.example.Greeting.dto.AuthUserDTO;
import com.example.Greeting.dto.JwtResponseDTO;
import com.example.Greeting.dto.LoginDTO;
import com.example.Greeting.model.AuthUser;
import com.example.Greeting.repository.AuthUserRepository;
import com.example.Greeting.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationService {

    @Autowired
    private AuthUserRepository authUserRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    public String register(AuthUserDTO authUserDTO) {
        if (authUserRepository.findByEmail(authUserDTO.getEmail()).isPresent()) {
            throw new RuntimeException("Email is already in use.");
        }

        AuthUser user = new AuthUser();
        user.setFirstName(authUserDTO.getFirstName());
        user.setLastName(authUserDTO.getLastName());
        user.setEmail(authUserDTO.getEmail());
        user.setPassword(passwordEncoder.encode(authUserDTO.getPassword()));

        authUserRepository.save(user);
        return "User registered successfully!";
    }

    public JwtResponseDTO login(LoginDTO loginDTO) {
        Optional<AuthUser> userOptional = authUserRepository.findByEmail(loginDTO.getEmail());

        if (userOptional.isEmpty()) {
            throw new RuntimeException("User not found!");
        }

        AuthUser user = userOptional.get();
        if (!passwordEncoder.matches(loginDTO.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid email or password!");
        }

        String token = jwtUtil.generateToken(user.getEmail());
        return new JwtResponseDTO("Login successful!", token);
    }


    //UC-12 Forgot Password Implementation
    public void forgotPassword(String email, String newPassword) {
        Optional<AuthUser> userOptional = authUserRepository.findByEmail(email);

        if (userOptional.isEmpty()) {
            throw new RuntimeException("Sorry! We cannot find the user email: " + email);
        }

        AuthUser user = userOptional.get();
        user.setPassword(passwordEncoder.encode(newPassword)); // Hash new password
        authUserRepository.save(user);

        // TODO: Send email notification (Optional)
        System.out.println("Email sent: Your password has been changed successfully.");
    }

    //UC-13 Reset Password
    public String resetPassword(String email, String currentPassword, String newPassword) {
        Optional<AuthUser> userOptional = authUserRepository.findByEmail(email);

        if (userOptional.isEmpty()) {
            throw new RuntimeException("User not found with email: " + email);
        }

        AuthUser user = userOptional.get();

        // Validate the current password
        if (!passwordEncoder.matches(currentPassword, user.getPassword())) {
            throw new RuntimeException("Current password is incorrect!");
        }

        // Hash and update the new password
        user.setPassword(passwordEncoder.encode(newPassword));
        authUserRepository.save(user);

        return "Password reset successfully!";
    }

}
