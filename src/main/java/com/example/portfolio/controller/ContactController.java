package com.example.portfolio.controller;

import com.example.portfolio.form.ContactForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
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

    @Autowired
    private JavaMailSender mailSender; //JavaMailSenderを注入

    //フォームからの送信を受け取る
    @PostMapping("/contact/send")
    public String send(@ModelAttribute ContactForm contactForm) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("自分のメールアドレス"); // 送信先
        message.setSubject("ポートフォリオからのお問い合わせ: " + contactForm.getName());
        message.setText("目的: " + contactForm.getPurpose() + "\n" +
                "内容: " + contactForm.getMessage());

        mailSender.send(message); // ここでメール送信！

        //送信完了ページにとばす
        return "redirect:/contact/thanks";
    }

    @GetMapping("/contact/thanks")
    public String thanks() {
        return "thanks";
    }
}
