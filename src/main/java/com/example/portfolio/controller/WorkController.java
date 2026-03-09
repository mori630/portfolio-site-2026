package com.example.portfolio.controller;

import com.example.portfolio.repository.WorkRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
}
