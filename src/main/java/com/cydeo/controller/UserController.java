package com.cydeo.controller;

import com.cydeo.dto.UserDTO;
import com.cydeo.bootstrap.DataGenerator;
import com.cydeo.service.RoleService;
import com.cydeo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@Controller
@RequestMapping("/user")
public class UserController {

    RoleService roleService;
    UserService userService;

    public UserController(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @GetMapping("/create")
    public String createUser(Model model){

        model.addAttribute("user", new UserDTO());

        model.addAttribute("roles", roleService.findAll());
        model.addAttribute("users", userService.findAll());

        return "user/create";
    }

    @PostMapping("/create")
    public String userListUpdate(@ModelAttribute("user") UserDTO user){

        userService.save(user);

        //return "/user/create";
         return "redirect:/user/create";
    }

    @GetMapping("/update/{username}")
    public String editUser(@PathVariable("username") String username, Model model){

        model.addAttribute("user", userService.findById(username));

        model.addAttribute("roles", roleService.findAll());
        model.addAttribute("users", userService.findAll());

        return "user/update";
    }

    @PostMapping("/update")
    public String saveEditedUser(UserDTO user){
        userService.update(user);
        return "redirect:/user/create";
    }

    @GetMapping ("/delete/{username}")
    public String deleteUser(@PathVariable("username") String username){
        userService.deleteById(username);
        return "redirect:/user/create";
    }


}
