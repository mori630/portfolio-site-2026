package com.example.portfolio.controller;

import com.example.portfolio.form.ContactForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ContactController {

    @GetMapping("/contact")
    public String contact() {
        return "contact";   // templatesフォルダ内の contact.html を表示する
    }

    //フォームからの送信を受け取る
    @PostMapping("/contact/send")
    public String send(@ModelAttribute ContactForm contactForm) {
        //コンソールに内容を表示して確認
        System.out.println("--- お問い合わせ内容 ---");
        System.out.println("目的: " + contactForm.getPurpose());
        System.out.println("お名前: " + contactForm.getName());
        System.out.println("メール: " + contactForm.getEmail());
        System.out.println("メッセージ: " + contactForm.getMessage());

        //とりあえず送信完了ページにとばす
        return "redirect:/";
    }
}
