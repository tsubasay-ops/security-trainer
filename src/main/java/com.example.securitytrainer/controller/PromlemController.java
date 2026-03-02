package com.example.securitytrainer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.securitytrainer.service.ProblemService;

@Controller
public class ProblemController {

    private final ProblemService problemService;

    public ProblemController(ProblemService problemService) {
        this.problemService = problemService;
    }

    @GetMapping("/problem")
    public String showProblem(Model model) {
        model.addAttribute("problem", problemService.getSampleProblem());
        return "problem";
    }
}