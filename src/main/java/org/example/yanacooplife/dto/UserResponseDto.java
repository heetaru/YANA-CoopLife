package org.example.yanacooplife.dto;

public record UserResponseDto(
        Long id,
        String name,
        String email,
        Long score
) {
}
