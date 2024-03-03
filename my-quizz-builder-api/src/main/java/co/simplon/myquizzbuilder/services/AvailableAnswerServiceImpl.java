package co.simplon.myquizzbuilder.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.simplon.myquizzbuilder.dtos.quiz.AnswerCreateDto;
import co.simplon.myquizzbuilder.dtos.quiz.AnswerVueDto;
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
    public void create(AnswerCreateDto inputs,
	    Long questionId) {
	AvailableAnswer entity = new AvailableAnswer();
	entity.setName(inputs.name());
	entity.setValid(inputs.valid());
	entity.setAnswerIndex(inputs.answerIndex());
	Question question = questions
		.findOneProjectedById(questionId);
	entity.setQuestion(question);
	availableAnswers.save(entity);
    }

    @Override
    public List<AnswerVueDto> answerVue(Long questionId) {
	List<Long> availableAnswersId = availableAnswers
		.getAnswersId(questionId);
	List<AnswerVueDto> answerList = new ArrayList<>();
	for (Long availableAnswerId : availableAnswersId) {
	    AnswerVueDto answer = availableAnswers
		    .findOneProjectedById(
			    availableAnswerId);
	    answerList.add(answer);
	}
	return answerList;
    }
}
