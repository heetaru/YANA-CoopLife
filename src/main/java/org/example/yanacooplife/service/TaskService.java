package org.example.yanacooplife.service;


import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.example.yanacooplife.dto.TaskDto;
import org.example.yanacooplife.entity.Task;
import org.example.yanacooplife.entity.User;
import org.example.yanacooplife.mapper.TaskMapper;
import org.example.yanacooplife.repository.TaskRepository;
import org.example.yanacooplife.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    private final TaskMapper taskMapper;

    public TaskDto createTask(
            Long userId,
            TaskDto taskDto
    ){

        User currentUser = userRepository.findById(userId)
                .orElseThrow(
                        () -> new EntityNotFoundException("User with id" + userId + "doesnt exist")
                );
        Task newTask = taskMapper.toEntity(taskDto, currentUser);

        var savedTask = taskRepository.save(newTask);

        return taskMapper.toDto(savedTask);
    }

    public List<TaskDto> getTasksByUserId(Long userId) {

        userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("Cannot find user with id = " + userId));

        List<Task> tasks = taskRepository.findByUserId(userId);

        return tasks.stream()
                .map(taskMapper::toDto)
                .toList();
    }
}
