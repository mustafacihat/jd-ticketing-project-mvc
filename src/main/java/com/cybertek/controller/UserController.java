package com.cybertek.controller;


import com.cybertek.dto.RoleDTO;
import com.cybertek.dto.UserDTO;
import com.cybertek.implementation.RoleServiceImpl;
import com.cybertek.service.RoleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Arrays;


@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping({"/create","/add","/initialize"})
    public String createUser(Model model){

        model.addAttribute("user", new UserDTO());

        return "/user/create";
    }

    @PostMapping("/create")
    public String saveUser(@ModelAttribute("user") UserDTO user,Model model){

        model.addAttribute("userList", Arrays.asList(user));
        return "/user/create";

    }

}
