package com.david.englishnow.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="question")
public class Question {

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="content")
    private String content;

    @OneToMany(mappedBy = "question",  // refers to 'question' property in AnswerChoice
               fetch = FetchType.EAGER,  // when getting a question, eagerly get its answer choices as well
               cascade = CascadeType.ALL)
    private List<AnswerChoice> answerChoices;

    // difficulty?

    // language?

    public Question() {
    }

    public Question(String content) {
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<AnswerChoice> getAnswerChoices() {
        return answerChoices;
    }

    public void setAnswerChoices(List<AnswerChoice> answerChoices) {
        this.answerChoices = answerChoices;
    }

    // convenience methods for adding answer choices
    public void addAnswerChoice(AnswerChoice answerChoice) {
        if (answerChoices == null)
            answerChoices = new ArrayList<>();

        answerChoices.add(answerChoice);
        answerChoice.setQuestion(this);
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", question='" + content + '\'' +
                '}';
    }
}











