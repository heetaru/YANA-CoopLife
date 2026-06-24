package org.example.yanacooplife.dto;

import jakarta.validation.constraints.*;

public record UserCreateDto(
        @Size(min = 2, max = 50, message = "Name must have 2-50 letters")
        @NotBlank(message = "Name cannot be empty")
        String name,

        @Email(message = "Incorrect email")
        @NotBlank(message = "Email cannot be empty")
        String email,

        @Size(min = 6, max = 50, message = "Password must have 6-50 letters")
        @NotBlank(message = "Password cannot be empty")
        String password
) {
}
