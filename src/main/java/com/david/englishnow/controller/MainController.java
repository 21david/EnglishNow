package com.david.englishnow.controller;

import com.david.englishnow.entity.AnswerChoice;
import com.david.englishnow.entity.Question;
import com.david.englishnow.repository.AnswerChoiceRepository;
import com.david.englishnow.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    // for testing GET, delete later
   @Autowired
   QuestionRepository qr;

    @GetMapping("/")
    public String sayHello(Model model) {

        return "home";
    }

   // For testing through postman
   @GetMapping("/questions")
   public ResponseEntity<List<Question>> getQs() {
       List<Question> qs = qr.findAll();
       return new ResponseEntity<>(qs, HttpStatus.OK);
   }

//    @PostMapping("/gradeQuiz")
//    public String gradeQuiz(Model model, @RequestParam Map<String, String> answers) {
//
//    }
}
