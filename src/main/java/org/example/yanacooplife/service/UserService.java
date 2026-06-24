package org.example.yanacooplife.service;


import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.example.yanacooplife.dto.UserCreateDto;
import org.example.yanacooplife.dto.UserResponseDto;
import org.example.yanacooplife.entity.User;
import org.example.yanacooplife.mapper.TaskMapper;
import org.example.yanacooplife.mapper.UserMapper;
import org.example.yanacooplife.repository.TaskRepository;
import org.example.yanacooplife.repository.UserRepository;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final TaskRepository taskRepository;

    private final UserMapper userMapper;
    private final TaskMapper taskMapper;

    public List<UserResponseDto> getAllUsers(){
        List<User> users = userRepository.findAll();

        return users.stream()
                .map(userMapper::toDto)
                .toList();
    }

    public UserResponseDto createUser(
        UserCreateDto userToCreate
    ){
        if (userRepository.findByEmail(userToCreate.email()).isPresent()){
            throw new EntityNotFoundException("Your email was used to another account");
        }
        User newUser = userMapper.toEntity(userToCreate);

        User savedUser = userRepository.save(newUser);

        return userMapper.toDto(savedUser);
    }
}
