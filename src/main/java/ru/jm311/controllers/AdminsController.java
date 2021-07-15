package ru.jm311.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.jm311.entity.Role;
import ru.jm311.entity.User;
import ru.jm311.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/admin/")
public class AdminsController {

    private final UserService userService;

    public AdminsController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String showUserList(ModelMap model) {
        List<Role> listRoles = userService.listRoles();
        model.addAttribute("listRoles", listRoles);
        model.addAttribute("users", userService.getAllUser());
        model.addAttribute("user", new User());
        return "admin/userList";
    }

    @PostMapping("/add")
    public String addUser(@ModelAttribute("newUser") User user,
                          @RequestParam(required = false, name = "listRoles") String[] input_roles) { //, HttpServletRequest request
        user.setRoles(userService.getRolesByName(input_roles));
        userService.addUser(user);
        return "redirect:/admin/";
    }

    @GetMapping("/{id}")
    public String findUserById(@PathVariable("id") Long id, ModelMap model) {
        User user = userService.getUser(id);

        if (user == null) {
            return "redirect:/admin/";
        }
        model.addAttribute("user", user);
        return "admin/edit";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.PATCH)
    public String edit(@ModelAttribute("user") User user,
                       @PathVariable("id") Long id,
                       @RequestParam(required = false, name = "listRoles") String[] input_roles) {
        user.setRoles(userService.getRolesByName(input_roles));
        userService.editUser(id, user);
        return "admin/edit";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/admin/";
    }
}
