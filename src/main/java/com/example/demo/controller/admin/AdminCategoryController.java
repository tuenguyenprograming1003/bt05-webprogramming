package com.example.demo.controller.admin;

import com.example.demo.entity.Category;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/categories")
public class AdminCategoryController {

    @Autowired
    private CategoryRepository categoryRepo;

    @Autowired
    private UserRepository userRepo;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("items", categoryRepo.findAll());
        return "admin/category/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("item", new Category());
        model.addAttribute("users", userRepo.findAll());
        return "admin/category/form";
    }

    @PostMapping("/save")
    public String save(Category category) {
        categoryRepo.save(category);
        return "redirect:/admin/categories";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
        Category category = categoryRepo.findById(id).orElseThrow();
        model.addAttribute("item", category);
        model.addAttribute("users", userRepo.findAll());
        return "admin/category/form";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        categoryRepo.deleteById(id);
        return "redirect:/admin/categories";
    }
}

