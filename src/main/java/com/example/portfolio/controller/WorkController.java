package com.example.portfolio.controller;

import com.example.portfolio.model.Work;
import com.example.portfolio.repository.WorkRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class WorkController {

    //コンストラクタでリポジトリを注入
    private final WorkRepository workRepository;
    public WorkController(WorkRepository workRepository) {
        this.workRepository = workRepository;
    }

    @GetMapping("/")
    public String index(Model model) {
        model .addAttribute("works", workRepository.findAll());
        return "index";
    }

    @GetMapping("/work/{id}")
    public String detail(@PathVariable("id") Long id, Model model) {
        //IDをもとに作品を取得。なければエラー（トップへ）
        Work work = workRepository.findById(id).orElseThrow(() -> new RuntimeException("Work not found"));
        return "detail";
    }
}
