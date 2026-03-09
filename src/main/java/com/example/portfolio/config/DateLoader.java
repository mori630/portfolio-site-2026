package com.example.portfolio.config;

import com.example.portfolio.model.Work;
import com.example.portfolio.repository.WorkRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.sql.SQLOutput;

//Spring Bootに、このクラスは特別な仕事をする部品と指示。
@Component
public class DateLoader implements CommandLineRunner {

    private final WorkRepository repository;

    //リポジトリを使えるようにする
public DateLoader(WorkRepository repository) {
    this.repository = repository;
}

@Override
    public void run(String...args) throws Exception {
    //一件目のデータを作成
    Work work1 = new Work();
    work1.setTitle("私のポートフォリオサイト");
    work1.setDescriptionShort("Spring Bootで作成した自己紹介サイトです。");
    work1.setDescriptionDetail("このサイトは、自分のスキルを証明するために作成しました。ER図による設計から始め、GitHubでの管理も行っています。");
    work1.setTechStack("Java, Spring Boot, Thymeleaf, H2 Database");
    work1.setDifficulties("Gitの競合（コンフリクト）の解決に苦労しました。");
    work1.setSolutions("一つずつコマンドを確認し、強制Pushなどの仕組みを理解することで解決しました。");
    work1.setGithubUrl("https://github.com/mori630/portfolio-site-2026");

    repository.save(work1);

    System.out.println("初期データの登録が完了しました");
}
}
