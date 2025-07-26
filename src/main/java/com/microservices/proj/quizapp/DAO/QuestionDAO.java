package com.microservices.proj.quizapp.DAO;

import com.microservices.proj.quizapp.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDAO extends JpaRepository<Question, Integer> {

    List<Question> findByCategory(String category);

    @Query(value = "Select * from Question q where q.category=:category ORDER BY Random() LIMIT :numQ",nativeQuery = true)
    List<Question> getQuestions(String category, int numQ);
}
