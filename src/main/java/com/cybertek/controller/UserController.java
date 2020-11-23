package com.cybertek.controller;


import com.cybertek.dto.RoleDTO;
import com.cybertek.dto.UserDTO;
import com.cybertek.entity.Role;
import com.cybertek.implementation.RoleServiceImpl;
import com.cybertek.service.RoleService;
import com.cybertek.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@Controller
@RequestMapping("/user")
public class UserController {

    RoleService roleService;
    UserService userService;

    public UserController(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @GetMapping({"/create","/add","/initialize"})
    public String createUser(Model model){

        model.addAttribute("user", new UserDTO());
        List<RoleDTO> rolesList = roleService.findAll();

        //List<String> rolesList = roles.stream().map(RoleDTO::getDescription).collect(Collectors.toList());

        model.addAttribute("rolesList",rolesList);

        return "/user/create";
    }

    @PostMapping("/create")
    public String saveUser(@ModelAttribute("user") UserDTO user,Model model,@ModelAttribute("roles") RoleDTO role){

        model.addAttribute("userList", Arrays.asList(user));
        model.addAttribute("roles",Arrays.asList(role));
        return "/user/create";

    }

}
