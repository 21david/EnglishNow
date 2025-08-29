package com.david.englishnow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.david.englishnow.entity.AnswerChoice;

public interface AnswerChoiceRepository extends JpaRepository<AnswerChoice, Integer> {
}
