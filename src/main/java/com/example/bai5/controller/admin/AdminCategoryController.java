package com.example.bai5.controller.admin;

import com.example.bai5.entity.Category;
import com.example.bai5.repository.CategoryRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/category")
public class AdminCategoryController {

    private final CategoryRepository categoryRepository;

    public AdminCategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("items", categoryRepository.findAll());
        return "admin/category/list";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("item", new Category());
        return "admin/category/form";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Category category) {
        categoryRepository.save(category);
        return "redirect:/admin/category/list";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("item", categoryRepository.findById(id).orElse(new Category()));
        return "admin/category/form";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute Category category) {
        categoryRepository.save(category);
        return "redirect:/admin/category/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        categoryRepository.deleteById(id);
        return "redirect:/admin/category/list";
    }
}

