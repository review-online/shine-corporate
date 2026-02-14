package com.shine.corporate.controller;

import com.shine.corporate.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    private final ContentService contentService;

    @Autowired
    public MainController(ContentService contentService) {
        this.contentService = contentService;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("companyInfo", contentService.getCompanyInfo());
        model.addAttribute("businesses", contentService.getBusinessDetails());
        model.addAttribute("pageTitle", "株式会社SHINE | お酒を通じて豊かな時間を創造");
        return "index";
    }

    @GetMapping("/message")
    public String message(Model model) {
        model.addAttribute("ceoMessage", contentService.getCeoMessage());
        model.addAttribute("companyInfo", contentService.getCompanyInfo());
        return "message";
    }

    @GetMapping("/contact")
    public String contact(Model model) {
        model.addAttribute("companyInfo", contentService.getCompanyInfo());
        return "contact";
    }
}
