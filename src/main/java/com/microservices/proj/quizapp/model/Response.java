package com.microservices.proj.quizapp.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Response {
    private int id;

    @Override
    public String toString() {
        return "Response{" +
                "id=" + id +
                ", answer='" + answer + '\'' +
                '}';
    }

    private String answer;


    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }






}
