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
    public void run(String... args) throws Exception {
        // 1つ目の作品
        Work work1 = new Work();
        work1.setTitle("私のポートフォリオサイト");
        work1.setDescriptionShort("Java/Spring Bootで構築した作品一覧サイトです。");
        work1.setDescriptionDetail("詳細な設計から実装までを一貫して行いました。");
        work1.setTechStack("Java, Spring Boot, Thymeleaf, H2");
        work1.setDifficulties("特になし");
        work1.setSolutions("特になし");
        work1.setGithubUrl("https://github.com/mori630/portfolio-site-2026");
        repository.save(work1);

        /* 2つ目の作品（作品が増えていくにつれてコピーして追加していく）
        Work work2 = new Work();
        work2.setTitle("新しいプロジェクト名");
        work2.setDescriptionShort("簡単な説明...");
        work2.setDescriptionDetail("詳細なこだわりポイント...");
        work2.setTechStack("Java, Spring Boot...");
        work2.setDifficulties("苦労したこと...");
        work2.setSolutions("解決策...");
        work2.setGithubUrl("https://github.com/...");
        repository.save(work2);

        System.out.println("✅ 初期データの登録が完了しました！");
         */

    }
}