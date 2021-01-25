package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import web.model.User;
import web.service.UserService;

import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/admin/")
    public String printUsers(Model model) {
        List<User> list = userService.listUsers();
        model.addAttribute("usersList", list);
        return "users";
    }

    @GetMapping("/admin")
    public String addUser() {
        return "redirect:/admin/";
    }
}
