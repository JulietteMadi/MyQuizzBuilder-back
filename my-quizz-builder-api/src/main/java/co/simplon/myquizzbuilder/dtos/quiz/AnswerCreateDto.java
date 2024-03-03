package co.simplon.myquizzbuilder.dtos.quiz;

public record AnswerCreateDto(String name,
	Boolean valid, Long answerIndex) {
}
