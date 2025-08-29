package com.david.englishnow;

import com.david.englishnow.repository.AnswerChoiceRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.david.englishnow.repository.QuestionRepository;
import com.david.englishnow.entity.Question;
import com.david.englishnow.entity.AnswerChoice;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class EnglishnowApplication {

	public static void main(String[] args) {
		SpringApplication.run(EnglishnowApplication.class, args);
		System.out.println("http://localhost:8080");
	}

	@Bean
	public CommandLineRunner commandLineRunner(QuestionRepository questionRepository, AnswerChoiceRepository answerChioceRepository) {

		return runner -> {
			Question question1 = new Question("Como se dice 'gato'?");
			List<AnswerChoice> choices1 = new ArrayList<>(List.of(
				new AnswerChoice("Dog"),
				new AnswerChoice("Cap"),
				new AnswerChoice("Cat", true),
				new AnswerChoice("Gat")
			));
			for (AnswerChoice choice : choices1)
				question1.addAnswerChoice(choice);
			for (AnswerChoice choice : choices1)
				answerChioceRepository.save(choice);

			Question question2 = new Question("Traduce la palabra 'ayer'.");
			List<AnswerChoice> choices2 = new ArrayList<>(List.of(
				new AnswerChoice("Yesterday", true),
				new AnswerChoice("Tomorrow"),
				new AnswerChoice("Evening"),
				new AnswerChoice("Air")
			));
			for (AnswerChoice choice : choices2)
				question2.addAnswerChoice(choice);
			for (AnswerChoice choice : choices2)
				answerChioceRepository.save(choice);

			Question question3 = new Question("Como se saluda?");
			List<AnswerChoice> choices3 = new ArrayList<>(List.of(
				new AnswerChoice("See you later!"),
				new AnswerChoice("Tell me a joke."),
				new AnswerChoice("Let's make plans."),
				new AnswerChoice("Hi. How are you?", true)
			));
			for (AnswerChoice choice : choices3)
				question3.addAnswerChoice(choice);
			for (AnswerChoice choice : choices3)
				answerChioceRepository.save(choice);
		};
	}
}
