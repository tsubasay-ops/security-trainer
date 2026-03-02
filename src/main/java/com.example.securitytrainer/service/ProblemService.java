package com.example.securitytrainer.service;

import org.springframework.stereotype.Service;
import com.example.securitytrainer.model.Problem;

@Service
public class ProblemService {

    public Problem getSampleProblem() {
        return new Problem(
                1L,
                "「問題のタイトル」",
                "/images/sample.png"
        );
    }
}