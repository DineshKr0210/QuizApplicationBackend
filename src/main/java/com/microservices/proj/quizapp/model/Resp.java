package com.microservices.proj.quizapp.model;

public class Resp {
    private String message;

    public Resp(String message) {
        this.message = message;
    }

    public String getMessage() { // ✅ Getter is required for JSON serialization
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}