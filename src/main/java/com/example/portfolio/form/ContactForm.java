package com.example.portfolio.form;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ContactForm {
    @NotBlank(message = "目的を選択してください")
    private String purpose;

    @NotBlank(message = "お名前を入力してください")
    private String name;

    @NotBlank(message = "メールアドレスを入力してください")
    @Email(message = "正しいメールアドレス形式で入力してください")
    private String email;

    private String company;
    private String position;
    private String url;

    @NotBlank(message = "お問い合わせ内容を入力してください")
    private String message;
}
