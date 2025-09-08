package com.david.englishnow.controller;

import com.david.englishnow.entity.AnswerChoice;
import com.david.englishnow.entity.Question;
import com.david.englishnow.repository.AnswerChoiceRepository;
import com.david.englishnow.repository.QuestionRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class MainController {

    @GetMapping("/")
    public String sayHello(Model model) {

        return "home";
    }

//    @PostMapping("/gradeQuiz")
//    public String gradeQuiz(Model model, @RequestParam Map<String, String> answers) {
//
//    }
}
