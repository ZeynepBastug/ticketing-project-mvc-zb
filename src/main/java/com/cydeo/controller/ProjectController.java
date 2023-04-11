package com.cydeo.controller;

import com.cydeo.dto.ProjectDTO;
import com.cydeo.service.ProjectService;
import com.cydeo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.websocket.server.PathParam;

@Controller
@RequestMapping("project")
public class ProjectController {

    UserService userService;
    ProjectService projectService;

    public ProjectController(UserService userService, ProjectService projectService) {

        this.userService = userService;
        this.projectService = projectService;
    }

    @GetMapping("/create")
    public String createProjectView(Model model){

        model.addAttribute("project" , new ProjectDTO());
        model.addAttribute("managers", userService.findManagers());
        model.addAttribute("projects", projectService.findAll());

        return "project/create";
    }

    @PostMapping("/create")
    public String createProject(ProjectDTO project){
        projectService.save(project);
        return "redirect:/project/create";
    }

    @GetMapping("/delete/{projectCode}")
    public String deleteProject(@PathVariable("projectCode") String projectCode){
        projectService.deleteById(projectCode);
        return "redirect:/project/create";
    }

    @GetMapping("/create/{projectCode}")
    public String completeProject(@PathVariable("projectCode") String projectCode){

        projectService.updateStatus(projectService.findById(projectCode));
        return "redirect:/project/create";
    }

    @GetMapping("/update/{projectCode}")
    public String editProject(@PathVariable("projectCode") String projectCode, Model model){

       model.addAttribute("project", projectService.findById(projectCode));

       model.addAttribute("managers", userService.findManagers());
       model.addAttribute("projects", projectService.findAll());

       return "project/update";
    }

    @PostMapping("/update/{projectCode}")
    public String updateProject(@PathVariable("projectCode") String projectCode, ProjectDTO project){
        projectService.update(project);
        return "redirect:/project/create";
    }


}
