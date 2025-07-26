package com.microservices.proj.quizapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Question  {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String category;
    private String difficultyLevel;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String questionTitle;
    private String rightAnswer;

    // Explicit Getters to fix Jackson serialization issue
    public Integer getId() {
        return id;
    }

    public String getCategory() {
        return category;
    }

    public String getDifficultyLevel() {
        return difficultyLevel;
    }

    public String getOption1() {
        return option1;
    }

    public String getOption2() {
        return option2;
    }

    public String getOption3() {
        return option3;
    }

    public String getOption4() {
        return option4;
    }

    public String getQuestionTitle() {
        return questionTitle;
    }

    public String getRightAnswer() {
        return rightAnswer;
    }
}