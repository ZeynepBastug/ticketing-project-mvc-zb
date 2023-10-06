package com.cydeo.controller;

import com.cydeo.dto.TaskDTO;
import com.cydeo.service.ProjectService;
import com.cydeo.service.TaskService;
import com.cydeo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/task")
public class TaskController {

    ProjectService projectService;
    UserService userService;
    TaskService taskService;

    public TaskController(ProjectService projectService, UserService userService, TaskService taskService) {
        this.projectService = projectService;
        this.userService = userService;
        this.taskService = taskService;
    }

    @GetMapping("/create")
    public String taskCreateView(Model model){
         model.addAttribute("task", new TaskDTO());
         model.addAttribute("assignedEmployees", userService.findAll());
         model.addAttribute("projects", projectService.findAll());
         model.addAttribute("tasks", taskService.findAll());

        return "/task/create";
    }

    @PostMapping("/create")
    public String taskCreate(TaskDTO taskDTO){

        taskService.save(taskDTO);
        return "redirect:/task/create";
    }

    @GetMapping ("/update/{id}")
    public String taskUpdate(@PathVariable ("id") Long id, Model model){
        model.addAttribute("task", taskService.findById(id));
        model.addAttribute("assignedEmployees", userService.findAll());
        model.addAttribute("projects", projectService.findAll());
        model.addAttribute("tasks", taskService.findAll());

        return "/task/update";
    }
//    @PostMapping ("/update/{taskId}")
//    public String taskUpdate(@PathVariable ("taskId") Long id,TaskDTO task){
//        task.setId(id);
//        taskService.update(task);
//        return "redirect:/task/create";
//    }

    @PostMapping("/update/{id}")
    public String taskUpdate(TaskDTO task){
        taskService.update(task);
        return "redirect:/task/create";
    }

}
