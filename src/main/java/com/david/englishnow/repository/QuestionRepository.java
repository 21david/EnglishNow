package com.david.englishnow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.david.englishnow.entity.Question;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
}
