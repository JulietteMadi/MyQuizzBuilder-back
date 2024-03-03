package co.simplon.myquizzbuilder.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import co.simplon.myquizzbuilder.entities.Question;

public interface QuestionRepository
	extends JpaRepository<Question, Long> {

    @Query(value = "SELECT q.id AS id FROM Question q WHERE q.quiz.id = :quizId ORDER BY q.questionIndex")
    List<Long> getQuestionsByQuizId(
	    @Param("quizId") Long quizId);

    Question findOneProjectedById(Long questionId);

    @Query(value = "SELECT q FROM Question q WHERE q.quiz.id = :quizId AND q.questionIndex = :questionIndex")
    Question getQuestionToUpdate(
	    @Param("quizId") Long quizId,
	    @Param("questionIndex") Long questionIndex);

    @Modifying
    @Query("DELETE FROM Question q WHERE q.quiz.id = :quizId")
    void deleteInBulkByQuizId(@Param("quizId") Long quizId);
}
