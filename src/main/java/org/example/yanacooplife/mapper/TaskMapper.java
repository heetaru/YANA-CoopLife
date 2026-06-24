package org.example.yanacooplife.mapper;

import org.example.yanacooplife.dto.TaskDto;
import org.example.yanacooplife.entity.Task;
import org.example.yanacooplife.entity.User;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper {

    public TaskDto toDto(Task task) {
        if (task == null) return null;

        return new TaskDto(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getUser().getId()
        );
    }
    public Task toEntity(TaskDto taskDto, User user){
        if (taskDto == null) return null;

        Task task = new Task();
        task.setTitle(taskDto.title());
        task.setDescription(taskDto.description());

        task.setUser(user);

        return task;
    }
}
