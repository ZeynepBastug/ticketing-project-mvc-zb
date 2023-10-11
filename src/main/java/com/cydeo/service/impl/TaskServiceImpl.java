package com.cydeo.service.impl;

import com.cydeo.dto.TaskDTO;
import com.cydeo.dto.UserDTO;
import com.cydeo.enums.Status;
import com.cydeo.service.TaskService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl extends AbstractMapService<TaskDTO, Long> implements TaskService {

    @Override
    public TaskDTO save(TaskDTO task) {
        if(task.getStatus() == null){
            task.setStatus(Status.OPEN);
        }
        if(task.getAssignedDate() == null){
            task.setAssignedDate(LocalDate.now());
        }
        if(task.getId() == null){
            task.setId(UUID.randomUUID().getMostSignificantBits());
        }
        return super.save(task.getId(), task);
    }

    @Override
    public List<TaskDTO> findAll() {
        return super.findAll();
    }

    @Override
    public TaskDTO findById(Long id) {
        return super.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void update(TaskDTO object) {
        TaskDTO task = findById(object.getId());

        object.setStatus(task.getStatus());
        object.setAssignedDate(task.getAssignedDate());
//        object.setProject(task.getProject());
//        object.setAssignedEmployee(task.getAssignedEmployee());

        super.update(object.getId(), object);
    }

    @Override
    public List<TaskDTO> findAllTasksByStatus(Status status) {
        return findAll().stream().filter(task -> task.getStatus().getValue().equals(status.getValue())).collect(Collectors.toList());

    }

    @Override
    public List<TaskDTO> findAllTasksByStatusIsNot(Status status) {
        return findAll().stream().filter(task -> !task.getStatus().getValue().equals(status.getValue())).collect(Collectors.toList());
    }

    @Override
    public List<TaskDTO> findTasksByManager(UserDTO user) {
        return findAll().stream().filter(task -> task.getAssignedEmployee().getUserName().equals(user.getUserName())).collect(Collectors.toList());
    }
}
