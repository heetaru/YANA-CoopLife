package org.example.yanacooplife.dto;

import org.example.yanacooplife.entity.User;

public record TaskDto(
        Long id,
        String title,
        String description,
        Long userId
) {}
