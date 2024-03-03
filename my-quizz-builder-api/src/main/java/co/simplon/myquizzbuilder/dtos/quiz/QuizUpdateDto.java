package co.simplon.myquizzbuilder.dtos.quiz;

import java.util.List;

public record QuizUpdateDto(String name, String image,
	List<QuestionCreateDto> questions) {

}
