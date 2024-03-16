package co.simplon.myquizzbuilder.dtos.quiz;

import java.util.List;

public record QuizPlayedResultsDto(Long quizId,
	List<Boolean> answersResults) {

}
