package com.microservices.proj.quizapp.controller;

import com.microservices.proj.quizapp.dto.CorrectAnswerResponse;
import com.microservices.proj.quizapp.model.QuestionWrapper;
import com.microservices.proj.quizapp.model.Resp;
import com.microservices.proj.quizapp.model.Response;
import com.microservices.proj.quizapp.model.Title;
import com.microservices.proj.quizapp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("quiz")
public class QuizController {
    @Autowired
    QuizService quizService;


    @PostMapping("create")
        public ResponseEntity<Resp> createQuiz(@RequestParam String category, @RequestParam int numQ, @RequestParam String title){
        return quizService.createQuestion(category,numQ,title);
    }

    @GetMapping("getTitle")
    public ResponseEntity<List<Title>> gettitle(){
        return quizService.getTitle();
    }
    @GetMapping("question/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuestionById(@PathVariable int id){
        return quizService.getQuestionsByID(id);
    }
    @PostMapping("submit/{id}")
    public ResponseEntity<CorrectAnswerResponse> checkAnswer(@PathVariable Integer id, @RequestBody List<Response> response){
        return quizService.getRightAnswer(id,response);
    }
}
