package org.example.yanacooplife.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.yanacooplife.dto.TaskDto;
import org.example.yanacooplife.dto.UserCreateDto;
import org.example.yanacooplife.dto.UserResponseDto;
import org.example.yanacooplife.entity.Task;
import org.example.yanacooplife.service.TaskService;
import org.example.yanacooplife.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    private final UserService userService;
    private final TaskService taskService;

    @GetMapping
    public ResponseEntity<List<UserResponseDto>> getAllUsers(){
        logger.info("Called method getAllUsers");
        return ResponseEntity.status(HttpStatus.OK)
                .body(userService.getAllUsers());
    }

    @PostMapping("/{userId}/tasks")
    public ResponseEntity<TaskDto> createTask(
            @PathVariable("userId") Long userId,
            @RequestBody TaskDto taskDto) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(taskService.createTask(userId, taskDto));
    }


    @GetMapping("/{userId}/tasks")
    public ResponseEntity<List<TaskDto>> getUserTasks(
            @PathVariable("userId") Long userId
    ){
        logger.info("Called method getUserTasks");
        return ResponseEntity.status(HttpStatus.OK)
                .body(taskService.getTasksByUserId(userId));
    }



}
