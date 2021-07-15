package ru.jm311.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.jm311.entity.User;
import ru.jm311.service.UserService;
import java.security.Principal;

@Controller
@RequestMapping("/user")
public class UsersController {

    private final UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage() {
        return "users/login";
    }

    @GetMapping()
    public String showUserPage(ModelMap model, Principal principal) {
        User user = userService.findByName(principal.getName());
        model.addAttribute("user", user);
        return "users/user";
    }
}

































