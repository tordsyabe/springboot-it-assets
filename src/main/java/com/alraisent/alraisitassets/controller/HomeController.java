package com.alraisent.alraisitassets.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("title", "Home");
        model.addAttribute("titleHeader", "Dashboard");
        return "index";
    }

    @GetMapping("/assets")
    public String assetsPage(Model model) {
        model.addAttribute("title", "Assets");
        return "assets";
    }
}
