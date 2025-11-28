package com.example.bai5.controller.admin;

import com.example.bai5.entity.Video;
import com.example.bai5.entity.Category;
import com.example.bai5.repository.VideoRepository;
import com.example.bai5.repository.CategoryRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/video")
public class AdminVideoController {

    private final VideoRepository videoRepository;
    private final CategoryRepository categoryRepository;

    public AdminVideoController(VideoRepository videoRepository, CategoryRepository categoryRepository) {
        this.videoRepository = videoRepository;
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("items", videoRepository.findAll());
        return "admin/video/list";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("item", new Video());
        model.addAttribute("categories", categoryRepository.findAll());
        return "admin/video/form";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Video video, @RequestParam(value = "categoryId", required = false) Long categoryId) {
        if (categoryId != null) {
            Category cat = categoryRepository.findById(categoryId).orElse(null);
            video.setCategory(cat);
        } else {
            video.setCategory(null);
        }
        videoRepository.save(video);
        return "redirect:/admin/video/list";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("item", videoRepository.findById(id).orElse(new Video()));
        model.addAttribute("categories", categoryRepository.findAll());
        return "admin/video/form";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute Video video, @RequestParam(value = "categoryId", required = false) Long categoryId) {
        if (categoryId != null) {
            Category cat = categoryRepository.findById(categoryId).orElse(null);
            video.setCategory(cat);
        } else {
            video.setCategory(null);
        }
        videoRepository.save(video);
        return "redirect:/admin/video/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        videoRepository.deleteById(id);
        return "redirect:/admin/video/list";
    }
}
