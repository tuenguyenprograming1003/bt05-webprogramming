package com.example.bai5.controller.admin;

import com.example.bai5.entity.User;
import com.example.bai5.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/user")
public class AdminUserController {

    private final UserRepository userRepository;

    public AdminUserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("items", userRepository.findAll());
        return "admin/user/list";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("item", new User());
        return "admin/user/form";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute User user) {
        userRepository.save(user);
        return "redirect:/admin/user/list";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("item", userRepository.findById(id).orElse(new User()));
        return "admin/user/form";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute User user) {
        userRepository.save(user);
        return "redirect:/admin/user/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        userRepository.deleteById(id);
        return "redirect:/admin/user/list";
    }
}

