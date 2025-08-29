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
public class QuizController {

    private QuestionRepository questionRepository;
    private AnswerChoiceRepository answerChoiceRepository;

    public QuizController(QuestionRepository questionRepository, AnswerChoiceRepository answerChoiceRepository) {
        this.questionRepository = questionRepository;
        this.answerChoiceRepository = answerChoiceRepository;
    }

    @GetMapping("/quiz")
    public String sayHello(Model model) {
        List<Question> questions = questionRepository.findAll();
        model.addAttribute("questions", questions);
        return "quiz";
    }

    @PostMapping("/gradeQuiz")
    public String gradeQuiz(Model model, @RequestParam Map<String, String> answers) {
        List<Question> questions = questionRepository.findAll();
        model.addAttribute("questions", questions);
        Map<Integer, String> results = new HashMap<>();

        for (Map.Entry<String, String> userChoice : answers.entrySet()) {
            // Check if user's answer choice was correct
            int userAnswerChoiceID = Integer.parseInt(userChoice.getValue());
            boolean isCorrect = answerChoiceRepository.findById(userAnswerChoiceID).get().isCorrect();

            // Update map accordingly
            int questionId = Integer.parseInt(userChoice.getKey());
            results.put(questionId, isCorrect ? "Correcto!" : "Incorrecto.");
        }

        model.addAttribute("answers", answers);
        model.addAttribute("results", results);

        return "quiz";
    }
}
