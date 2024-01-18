package co.simplon.myquizzbuilder.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.simplon.myquizzbuilder.dtos.quiz.AvailableAnswerCreateDto;
import co.simplon.myquizzbuilder.entities.AvailableAnswer;
import co.simplon.myquizzbuilder.entities.Question;
import co.simplon.myquizzbuilder.repositories.AvailableAnswerRepository;
import co.simplon.myquizzbuilder.repositories.QuestionRepository;

@Service
@Transactional(readOnly = true)
public class AvailableAnswerServiceImpl
	implements AvailableAnswerService {

    private final AvailableAnswerRepository availableAnswers;
    private final QuestionRepository questions;

    public AvailableAnswerServiceImpl(
	    AvailableAnswerRepository availableAnswers,
	    QuestionRepository questions) {
	this.availableAnswers = availableAnswers;
	this.questions = questions;
    }

    @Override
    @Transactional
    public void create(AvailableAnswerCreateDto inputs,
	    Long questionId) {
	AvailableAnswer entity = new AvailableAnswer();
	entity.setName(inputs.getName());
	entity.setValid(inputs.getValid());
	Question question = questions
		.getReferenceById(questionId);
	entity.setQuestion(question);
	availableAnswers.save(entity);
    }
}
