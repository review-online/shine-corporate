package com.shine.corporate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ContactController {

    @PostMapping("/contact/submit")
    public String submitContact(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String message,
            @RequestParam(required = false) String phone,
            @RequestParam String category,
            Model model) {

        try {
            // 入力値のセキュリティ対策
            name = sanitizeInput(name);
            message = sanitizeInput(message);

            // コンソールにログ出力（実際の運用ではメール送信やDB保存）
            System.out.println("=== お問い合わせ受信 ===");
            System.out.println("名前: " + name);
            System.out.println("Email: " + email);
            System.out.println("カテゴリ: " + category);
            System.out.println("内容: " + message);

            model.addAttribute("successMessage",
                    "お問い合わせありがとうございます。担当者より2営業日以内にご連絡いたします。");
            model.addAttribute("name", name);
            return "contact_success";

        } catch (Exception e) {
            model.addAttribute("errorMessage",
                    "申し訳ございません。システムエラーが発生しました。お電話でお問い合わせください。");
            return "contact";
        }
    }

    private String sanitizeInput(String input) {
        if (input == null) return "";
        return input.replaceAll("<", "&lt;")
                .replaceAll(">", "&gt;")
                .trim();
    }
}
