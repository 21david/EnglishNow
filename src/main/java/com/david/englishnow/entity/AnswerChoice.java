package com.david.englishnow.entity;

import jakarta.persistence.*;

@Entity
@Table(name="answer_choice")
public class AnswerChoice {

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="content")
    private String content;

    @Column(name="is_correct")
    private boolean isCorrect;

    @ManyToOne(cascade={CascadeType.DETACH, CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name="question_id")  // Foreign key of this table
    private Question question;

    public AnswerChoice() {
    }

    public AnswerChoice(String content, boolean isCorrect) {
        this.content = content;
        this.isCorrect = isCorrect;
    }

    public AnswerChoice(String content) {
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

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect() {
        isCorrect = true;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    @Override
    public String toString() {
        return "AnswerChoice{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", isCorrect=" + isCorrect +
                ", question=" + question +
                '}';
    }
}











