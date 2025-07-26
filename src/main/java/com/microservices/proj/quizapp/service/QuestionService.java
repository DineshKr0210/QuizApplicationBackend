package com.microservices.proj.quizapp.service;

import com.microservices.proj.quizapp.DAO.QuestionDAO;
import com.microservices.proj.quizapp.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

@Autowired
QuestionDAO questionDAO;

    public ResponseEntity<List<Question>>  getAllQuestions() {
        try {
            return new ResponseEntity<>(questionDAO.findAll(), HttpStatus.OK);
        }catch(Exception e){
            e.fillInStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);

    }


    public ResponseEntity<List<Question>> getCategory(String category) {
        try {
        return new ResponseEntity<>(questionDAO.findByCategory(category),HttpStatus.OK);
        }catch(Exception e){
            e.fillInStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);

    }

    public ResponseEntity<String> addRecord(Question question) {
         questionDAO.save(question);
        try {
            return new ResponseEntity<>(
                    "Success", HttpStatus.CREATED);
        }catch(Exception e){
            e.fillInStackTrace();
        }
        return new ResponseEntity<>("", HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> deleteRecord(int id) {
        questionDAO.deleteById(id);
        try {
            return new ResponseEntity<>(
                    "Record Deleted", HttpStatus.CREATED);
        }catch(Exception e){
            e.fillInStackTrace();
        }
        return new ResponseEntity<>("Record Not Deleted", HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> updateRecord(Question question) {
        questionDAO.save(question);
        try {
            return new ResponseEntity<>(
                    "Record Updated", HttpStatus.CREATED);
        }catch(Exception e){
            e.fillInStackTrace();
        }
        return new ResponseEntity<>("Record Not Updated", HttpStatus.BAD_REQUEST);
    }
}