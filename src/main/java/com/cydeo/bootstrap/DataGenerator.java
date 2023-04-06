package com.cydeo.bootstrap;

import com.cydeo.dto.ProjectDTO;
import com.cydeo.dto.RoleDTO;
import com.cydeo.dto.UserDTO;
import com.cydeo.enums.Gender;
import com.cydeo.enums.Status;
import com.cydeo.service.ProjectService;
import com.cydeo.service.RoleService;
import com.cydeo.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataGenerator implements CommandLineRunner {
    RoleService roleService;
    UserService userService;
    ProjectService projectService;

    public DataGenerator(RoleService roleService, UserService userService, ProjectService projectService) {
        this.roleService=roleService;
        this.userService=userService;
        this.projectService=projectService;
    }

    @Override
    public void run(String... args) throws Exception {

        RoleDTO adminRole = new RoleDTO(1L, "Admin");
        RoleDTO managerRole = new RoleDTO(2L, "Manager");
        RoleDTO employeeRole = new RoleDTO(3L, "Employee");

        roleService.save(adminRole);
        roleService.save(managerRole);
        roleService.save(employeeRole);

        UserDTO user1 = new UserDTO("Hazel", "Bastug","hazel@gmail.com","1234","1234",true,managerRole, Gender.FEMALE);
        UserDTO user2 = new UserDTO("Rob", "Dough","rob@gmail.com","1234","1234",true,managerRole, Gender.MALE);
        UserDTO user3 = new UserDTO("Sia", "Kerkola","sia@gmail.com","1234","1234",true,employeeRole, Gender.FEMALE);
        UserDTO user4 = new UserDTO("Zeynep", "Bastug","zb@gmail.com","1234","1234",true,employeeRole, Gender.FEMALE);

        userService.save(user1);
        userService.save(user2);
        userService.save(user3);
        userService.save(user4);

        ProjectDTO project1 = new ProjectDTO("Form Manager", "1L23DF45", user1, LocalDate.now(), LocalDate.now(), "Working with Evoya team", Status.OPEN);
        ProjectDTO project2 = new ProjectDTO("PKeye", "1E90AS34P", user2, LocalDate.now(), LocalDate.now(), "Working with Evoya team", Status.IN_PROGRESS);
        ProjectDTO project3 = new ProjectDTO("Form Manager", "1P56MV63F", user1, LocalDate.now(), LocalDate.now(), "Working with Evoya team", Status.COMPLETE);

        projectService.save(project1);
        projectService.save(project2);
        projectService.save(project3);

    }
}
