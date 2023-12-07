package co.simplon.myquizzbuilder.services;

import co.simplon.myquizzbuilder.dtos.quiz.AvailableAnswerCreateDto;
import co.simplon.myquizzbuilder.entities.AvailableAnswer;
import co.simplon.myquizzbuilder.repositories.AvailableAnswerRepository;

public class AvailableAnswerServiceImpl
	implements AvailableAnswerService {

    private final AvailableAnswerRepository availableAnswers;

    public AvailableAnswerServiceImpl(
	    AvailableAnswerRepository availableAnswers) {
	this.availableAnswers = availableAnswers;
    }

    @Override
    public void create(AvailableAnswerCreateDto inputs,
	    Integer questionId) {
	AvailableAnswer entity = new AvailableAnswer();
	entity.setName(inputs.getName());
	entity.setValid(inputs.getValid());
    }
}
