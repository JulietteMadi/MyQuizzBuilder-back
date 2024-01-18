package co.simplon.myquizzbuilder.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.simplon.myquizzbuilder.dtos.quiz.AvailableAnswerCreateDto;
import co.simplon.myquizzbuilder.dtos.quiz.QuestionCreateDto;
import co.simplon.myquizzbuilder.entities.Question;
import co.simplon.myquizzbuilder.entities.Quiz;
import co.simplon.myquizzbuilder.entities.Topic;
import co.simplon.myquizzbuilder.repositories.QuestionRepository;
import co.simplon.myquizzbuilder.repositories.QuizRepository;
import co.simplon.myquizzbuilder.repositories.TopicRepository;

@Service
@Transactional(readOnly = true)
public class QuestionServiceImpl
	implements QuestionService {

    private final QuestionRepository questions;
    private final QuizRepository quizzes;
    private final TopicRepository topics;
    private final AvailableAnswerService availableAnswerServices;

    public QuestionServiceImpl(QuestionRepository questions,
	    QuizRepository quizzes, TopicRepository topics,
	    AvailableAnswerService availableAnswerServices) {
	this.questions = questions;
	this.quizzes = quizzes;
	this.topics = topics;
	this.availableAnswerServices = availableAnswerServices;
    }

    @Override
    public void create(QuestionCreateDto inputs,
	    Long quizId) {
	Question entity = new Question();
	entity.setName(inputs.getName());
	entity.setAnswerDescription(
		inputs.getAnswerDescription());
	Topic topic = topics
		.getReferenceById(inputs.getTopicId());
	entity.setTopic(topic);
	Quiz quiz = quizzes.getReferenceById(quizId);
	entity.setQuiz(quiz);
	Question newQuestion = questions.save(entity);
	Long questionId = newQuestion.getId();
	for (AvailableAnswerCreateDto availableAnswer : inputs
		.getAnswers()) {
	    this.availableAnswerServices
		    .create(availableAnswer, questionId);
	}
    }
}
