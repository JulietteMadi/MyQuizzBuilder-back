package co.simplon.myquizzbuilder.services;

import java.util.List;

import co.simplon.myquizzbuilder.dtos.quiz.AnswerVueDto;
import co.simplon.myquizzbuilder.dtos.quiz.AnswerCreateDto;

public interface AvailableAnswerService {
    void create(AnswerCreateDto inputs,
	    Long questionId);

    public List<AnswerVueDto> answerVue(Long questionId);
}
