package com.microservices.proj.quizapp.controller;

import com.microservices.proj.quizapp.model.Resp;
import com.microservices.proj.quizapp.model.Question;
import com.microservices.proj.quizapp.service.QuestionService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("questions")
public class QuestionController {
    @Autowired
    QuestionService questionService;

    @GetMapping("allQuestions")
    public ResponseEntity<List<Question>> allQuestion() {
        return questionService.getAllQuestions();
    }
    @GetMapping("/test")
    public ResponseEntity<Resp> helloWorld() {
        return ResponseEntity.ok(new Resp("Hello World Bean"));
    }




    @GetMapping("category/{category}")
    public ResponseEntity<List<Question>> questionCategory(@PathVariable String category) {
        return questionService.getCategory(category);

    }

    @PostMapping("add")
    public ResponseEntity<String> addRecord(@RequestBody Question question) {
        return questionService.addRecord(question);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteRecord(@PathVariable int id) {
        return questionService.deleteRecord(id);
    }
    @PutMapping("update")
    public ResponseEntity<String> updateRecord(@RequestBody Question question){
        return questionService.updateRecord(question);
    }

}
