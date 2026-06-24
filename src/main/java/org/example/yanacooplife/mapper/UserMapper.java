package org.example.yanacooplife.mapper;

import org.example.yanacooplife.dto.UserCreateDto;
import org.example.yanacooplife.dto.UserResponseDto;
import org.example.yanacooplife.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserResponseDto toDto(User user){
        if (user == null) return null;

        return new UserResponseDto(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getScore()
        );
    }

    public User toEntity(UserCreateDto userResponseDto){
        if (userResponseDto == null) return null;

        User user = new User();
        user.setName(userResponseDto.name());
        user.setEmail(userResponseDto.email());
        user.setPassword(userResponseDto.password());
        user.setScore(0L);

        return user;
    }
}
