package com.cybertek.controller;


import com.cybertek.dto.RoleDTO;
import com.cybertek.dto.UserDTO;
import com.cybertek.entity.Role;
import com.cybertek.implementation.RoleServiceImpl;
import com.cybertek.service.RoleService;
import com.cybertek.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Controller
@RequestMapping("/user")
public class UserController {

    RoleService roleService;
    UserService userService;

    public UserController(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @GetMapping("/create")//"/add","/initialize"})
    public String createUser(Model model) {

        model.addAttribute("user", new UserDTO());
        model.addAttribute("users", userService.findAll());
        model.addAttribute("roles", roleService.findAll());

        //List<String> rolesList = roles.stream().map(RoleDTO::getDescription).collect(Collectors.toList());


        return "/user/create";
    }

    @PostMapping("/create")
    public String insertUser(UserDTO user, Model model) {

        userService.save(user);
       /* model.addAttribute("user", new UserDTO());
        model.addAttribute("users",userService.findAll());
        model.addAttribute("roles",roleService.findAll());
*/
        //user.setRole(roleService.findById(user.getRoleId()));


        //model.addAttribute("user", new UserDTO());
        //List<RoleDTO> rolesList = roleService.findAll();

        //List<String> rolesList = roles.stream().map(RoleDTO::getDescription).collect(Collectors.toList());

        return "redirect:/user/create";

    }

    @GetMapping("/update/{username}")
    public String editUser(@PathVariable("username") String username, Model model) {


        model.addAttribute("user", userService.findById(username));
        model.addAttribute("users", userService.findAll());
        model.addAttribute("roles", roleService.findAll());
        return "/user/update";

    }

    @PostMapping("/update/{username}")
    public String updateUser(@PathVariable("username") String username, UserDTO user, Model model) {


        userService.deleteById(userService.findById(username).getUserName());
        userService.update(user);
    /*    model.addAttribute("user", new UserDTO());
        model.addAttribute("roles",roleService.findAll());
        model.addAttribute("users",userService.findAll());*/

        return "redirect:/user/create";
    }

    @GetMapping("/delete/{username}")
    public String deleteUser(@PathVariable("username") String username) {

        userService.deleteById(username);

        return "redirect:/user/create";
    }

}
