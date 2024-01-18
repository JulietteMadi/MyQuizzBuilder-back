package co.simplon.myquizzbuilder.repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import co.simplon.myquizzbuilder.dtos.quiz.QuizForListDto;
import co.simplon.myquizzbuilder.dtos.quiz.QuizVueDto;
import co.simplon.myquizzbuilder.entities.Quiz;

public interface QuizRepository
	extends JpaRepository<Quiz, String> {

    Quiz getReferenceById(Long quizId);

    Collection<QuizForListDto> findAllProjectedBy();

    void deleteById(Long id);

    QuizVueDto findProjectDetailById(Long id);

}