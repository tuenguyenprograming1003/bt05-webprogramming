package com.example.demo.controller.admin;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/users")
public class AdminUserController {

    @Autowired
    private UserRepository userRepo;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("items", userRepo.findAll());
        return "admin/user/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("item", new User());
        return "admin/user/form";
    }

    @PostMapping("/save")
    public String save(User user) {
        userRepo.save(user);
        return "redirect:/admin/users";
    }

    @GetMapping("/edit/{username}")
    public String edit(@PathVariable("username") String username, Model model) {
        User user = userRepo.findById(username).orElseThrow();
        model.addAttribute("item", user);
        return "admin/user/form";
    }

    @GetMapping("/delete/{username}")
    public String delete(@PathVariable("username") String username) {
        userRepo.deleteById(username);
        return "redirect:/admin/users";
    }
}

