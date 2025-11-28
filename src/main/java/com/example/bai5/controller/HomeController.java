package com.example.bai5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping({"/", "/home"})
    public String home(Model model) {
        model.addAttribute("message", "Trang chủ");
        return "home"; // resolves to /WEB-INF/views/home.jsp via view resolver / Sitemesh decorator
    }
}

