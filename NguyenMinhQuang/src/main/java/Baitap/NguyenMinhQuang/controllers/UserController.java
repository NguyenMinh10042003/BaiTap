package Baitap.NguyenMinhQuang.controllers;

import Baitap.NguyenMinhQuang.Entities.User;
import Baitap.NguyenMinhQuang.services.UserService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private UserService userService;
    @GetMapping
    public String showAllUsers(@NonNull Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "user/list";
    }
    @GetMapping("/add")
    public String addUserForm(@NonNull Model model) {
        model.addAttribute("user", new User());
        return "user/add";
    }
    @PostMapping("/add")
    public String addUser(@ModelAttribute("user") User user) {
        if(userService.getUserById(user.getId()).isEmpty())
            userService.addUser(user);
        return "redirect:/users";
    }
    @GetMapping("/edit/{id}")
    public String editUserForm(@NonNull Model model, @PathVariable long id)
    {
        var user = userService.getUserById(id).orElse(null);
        model.addAttribute("user", user != null ? user : new User());
        return "user/edit";
    }
    @PostMapping("/edit")
    public String editUser(@ModelAttribute("user") User user) {
        userService.updateUser(user);
        return "redirect:/users";
    }
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable long id) {
        if (userService.getUserById(id).isPresent()) {
            userService.deleteUserById(id);
        }
        return "redirect:/users";
    }
}
