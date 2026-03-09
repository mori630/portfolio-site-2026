package com.example.portfolio.model;

import jakarta.persistence.*;

@Entity
@Table(name = "works")
public class Work {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;                        //id
    private String title;                   //タイトル名

    @Column(name = "description_short")
    private String descriptionShort;

    @Column(columnDefinition = "TEXT")
    private String descriptionDetail;
    private String imageUrl;
    private String techStack;

    @Column(columnDefinition = "TEXT")
    private String difficulties;    //苦労した点

    @Column(columnDefinition = "TEXT")
    private String solutions;   //解決策
    private String githubUrl;   //GitHubのURL
}
