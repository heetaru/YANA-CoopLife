package org.example.yanacooplife.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.example.yanacooplife.dto.TaskDto;
import org.example.yanacooplife.service.TaskService;
import org.example.yanacooplife.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasks")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@SecurityRequirement(name = "Bearer Authentication")
public class TaskController {
    private static final Logger logger = LoggerFactory.getLogger(TaskController.class);

    private final TaskService taskService;
    private final UserService userService;



}
