package com.example.Greeting.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Pattern(regexp = "^[A-Z][a-z]*$", message = "First name must start with an uppercase letter")
    private String firstName;

    @Pattern(regexp = "^[A-Z][a-z]*$", message = "Last name must start with an uppercase letter")
    private String lastName;

    @Email(message = "Email should be valid")
    @Column(unique = true)
    private String email;

    private String password;
}
