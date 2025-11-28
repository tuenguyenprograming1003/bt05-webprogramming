package com.example.demo.controller.admin;

import com.example.demo.entity.Video;
import com.example.demo.repository.VideoRepository;
import com.example.demo.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/videos")
public class AdminVideoController {

    @Autowired
    private VideoRepository videoRepo;

    @Autowired
    private CategoryRepository categoryRepo;

    @GetMapping
    public String list(@RequestParam(name = "keyword", required = false) String keyword,
                       Model model) {
        List<Video> list;
        if (keyword != null && !keyword.isEmpty()) {
            list = videoRepo.findByTitleContainingIgnoreCase(keyword);
        } else {
            list = videoRepo.findAll();
        }
        model.addAttribute("items", list);
        model.addAttribute("keyword", keyword);
        return "admin/video/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("item", new Video());
        model.addAttribute("categories", categoryRepo.findAll());
        return "admin/video/form";
    }

    @PostMapping("/save")
    public String save(Video video) {
        videoRepo.save(video);
        return "redirect:/admin/videos";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
        Video video = videoRepo.findById(id).orElseThrow();
        model.addAttribute("item", video);
        model.addAttribute("categories", categoryRepo.findAll());
        return "admin/video/form";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        videoRepo.deleteById(id);
        return "redirect:/admin/videos";
    }
}

