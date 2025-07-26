package com.microservices.proj.quizapp.service;

import com.microservices.proj.quizapp.DAO.QuestionDAO;
import com.microservices.proj.quizapp.DAO.QuizDAO;
import com.microservices.proj.quizapp.dto.CorrectAnswerResponse;
import com.microservices.proj.quizapp.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class QuizService {
    @Autowired
    QuestionDAO questionDAO;
    @Autowired
    QuizDAO quizDAO;


    public ResponseEntity<Resp> createQuestion(String category, int numQ, String title) {
        List<Question> questions = questionDAO.getQuestions(category, numQ);
        Quiz q = new Quiz();
        q.setTitle(title);
        q.setQuestions(questions);
        quizDAO.save(q);

        return new ResponseEntity<>(new Resp("Success"), HttpStatus.OK);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuestionsByID(int id) {
        Optional<Quiz> quiz = quizDAO.findById(id);
        List<Question> questionFromDB = quiz.get().getQuestions();
//       List<QuestionWrapper> questionWrappers = new ArrayList<>();
//         for(Question q : questionFromDB){
//             QuestionWrapper qs = new QuestionWrapper(q.getId(),q.getQuestionTitle(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
//             questionWrappers.add(qs);
//         }
        List<QuestionWrapper> questionWrappers = questionFromDB.stream().map(q -> new QuestionWrapper(q.getId(), q.getQuestionTitle(), q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4())).collect(Collectors.toList());

        return new ResponseEntity<>(questionWrappers, HttpStatus.OK);
    }

    public ResponseEntity<CorrectAnswerResponse> getRightAnswer(Integer id, List<Response> responses) {
        Quiz quiz = quizDAO.findById(id).get();
        List<Question> questions = quiz.getQuestions();
        int i = 0;
        int right = 0;
        for (Response response : responses) {
            System.out.println(response.getAnswer()+":"+questions.get(i).getRightAnswer());
            if (response.getAnswer().equals(questions.get(i).getRightAnswer())) {
                right++;
            }
            i++;

        }

        CorrectAnswerResponse response = new CorrectAnswerResponse((int) right);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    public ResponseEntity<List<Title>> getTitle() {
        List<Quiz> quiz = quizDAO.getTitle();
        List<Title> title = quiz.stream().map(q->new Title(q.getId(),q.getTitle())).collect(Collectors.toList());

        return new ResponseEntity<>(title, HttpStatus.OK);
    }
}
