package com.example.portfolio.controller;

import com.example.portfolio.form.ContactForm;
import jakarta.validation.Valid;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
    public String contact(Model model) {
        //空のフォームを画面に渡す
        model.addAttribute("contactForm", new ContactForm());
        return "contact";   // templatesフォルダ内の contact.html を表示する
    }

    @Autowired
    private JavaMailSender mailSender; //JavaMailSenderを注入

    //フォームからの送信を受け取る
    @PostMapping("/contact/send")
    public String send(@Valid @ModelAttribute ContactForm contactForm, BindingResult bindingResult) {
        //もしエラーがあれば、送信せずにフォーム画面へ戻る
        if (bindingResult.hasErrors()){
            return "contact";
        }
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("自分のメールアドレス"); // 送信先
        message.setSubject("【ポートフォリオより】: " + contactForm.getName() + "様からのお問い合わせ");

        //全項目を連結して本文を作成
        StringBuilder body = new StringBuilder();
        body.append("お問い合わせ目的: ").append(contactForm.getPurpose()).append("\n");
        body.append("お名前: ").append(contactForm.getName()).append("\n");
        body.append("企業・団体名: ").append(contactForm.getCompany()).append("\n");
        body.append("役職: ").append(contactForm.getPosition()).append("\n");
        body.append("URL: ").append(contactForm.getUrl()).append("\n");
        body.append("メールアドレス: ").append(contactForm.getEmail()).append("\n");
        body.append("----------------------------\n");
        body.append("お問い合わせ内容:\n").append(contactForm.getMessage());

        message.setText(body.toString());

        mailSender.send(message); // ここでメール送信

        return "redirect:/contact/thanks";
    }

    @GetMapping("/contact/thanks")
    public String thanks() {
        return "thanks";
    }
}
