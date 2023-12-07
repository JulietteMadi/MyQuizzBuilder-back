package co.simplon.myquizzbuilder.services;

import co.simplon.myquizzbuilder.dtos.quiz.AvailableAnswerCreateDto;

public interface AvailableAnswerService {
    void create(AvailableAnswerCreateDto inputs,
	    Integer questionId);
}
