package com.example.Greeting.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthUserDTO {

    @NotBlank
    @Pattern(regexp = "^[A-Z][a-z]*$", message = "First name must start with an uppercase letter")
    private String firstName;

    @Pattern(regexp = "^[A-Z][a-z]*$", message = "Last name must start with an uppercase letter")
    private String lastName;

    @Email(message = "Email should be valid")
    private String email;

    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[@#$%^&*()-+=])(?=.*[0-9]).{8,}$",
            message = "Password must contain at least 1 uppercase letter, 1 special character, 1 number, and be at least 8 characters long")
    private String password;
}
