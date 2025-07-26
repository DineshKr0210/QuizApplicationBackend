package com.microservices.proj.quizapp.DAO;

import com.microservices.proj.quizapp.model.Question;
import com.microservices.proj.quizapp.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizDAO extends JpaRepository<Quiz, Integer> {
    @Query(value = "SELECT DISTINCT ON (q.title) q.id, q.title FROM quiz q ORDER BY q.title, q.id;",nativeQuery = true)
    List<Quiz> getTitle();

}
