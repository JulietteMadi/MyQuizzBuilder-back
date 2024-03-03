package co.simplon.myquizzbuilder.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import co.simplon.myquizzbuilder.dtos.quiz.AnswerVueDto;
import co.simplon.myquizzbuilder.entities.AvailableAnswer;

public interface AvailableAnswerRepository
	extends JpaRepository<AvailableAnswer, Long> {

    AnswerVueDto findOneProjectedById(
	    Long availableAnswerId);

    @Query(value = "SELECT a.id AS id FROM AvailableAnswer a WHERE a.question.id = :questionId ORDER BY a.answerIndex")
    List<Long> getAnswersId(
	    @Param("questionId") Long questionId);

}
