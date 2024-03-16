package co.simplon.myquizzbuilder.repositories;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import co.simplon.myquizzbuilder.dtos.quiz.QuizForListDto;
import co.simplon.myquizzbuilder.entities.Quiz;

public interface QuizRepository
	extends JpaRepository<Quiz, Long> {

    @Override
    Quiz getReferenceById(Long quizId);

    Collection<QuizForListDto> findAllProjectedBy();

    @Override
    void deleteById(Long id);

    @Query(value = "SELECT q.id AS quizId FROM Quiz q WHERE q.manager.id = :managerId")
    List<Long> findAllByManager(
	    @Param("managerId") Long managerId);

    @Override
    Optional<Quiz> findById(Long id);

    @Query(value = "SELECT count(*) FROM Question q WHERE q.quiz.id = :quizId")
    Long numberOfQuestions(@Param("quizId") Long quizId);

    boolean existsByName(String string);

    boolean existsByManagerId(Long userId);

}