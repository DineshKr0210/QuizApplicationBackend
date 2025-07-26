package com.microservices.proj.quizapp.dto;

public class CorrectAnswerResponse {
    private int correctAnswer;

    public CorrectAnswerResponse(int correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(int correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
}