package co.simplon.myquizzbuilder.services;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.simplon.myquizzbuilder.dtos.quiz.QuestionCreateDto;
import co.simplon.myquizzbuilder.dtos.quiz.QuestionVueDto;
import co.simplon.myquizzbuilder.dtos.quiz.QuizCreateDto;
import co.simplon.myquizzbuilder.dtos.quiz.QuizForListDto;
import co.simplon.myquizzbuilder.dtos.quiz.QuizPlayedResultsDto;
import co.simplon.myquizzbuilder.dtos.quiz.QuizUpdateDto;
import co.simplon.myquizzbuilder.dtos.quiz.QuizVueDto;
import co.simplon.myquizzbuilder.dtos.quiz.ResultQuizToReturnDto;
import co.simplon.myquizzbuilder.entities.Manager;
import co.simplon.myquizzbuilder.entities.Quiz;
import co.simplon.myquizzbuilder.repositories.QuizRepository;
import co.simplon.myquizzbuilder.repositories.UserRepository;

@Service
@Transactional(readOnly = true)
public class QuizServiceImpl implements QuizService {
    private final QuizRepository quizzes;
    private final UserRepository users;
    private final QuestionService questionServices;

    QuizServiceImpl(QuizRepository quizzes,
	    UserRepository users,
	    QuestionService questionServices) {
	this.quizzes = quizzes;
	this.users = users;
	this.questionServices = questionServices;
    }

    @Override
    @Transactional
    public void create(QuizCreateDto inputs) {
	Quiz entity = new Quiz();
	entity.setName(inputs.getName());
	entity.setImage(inputs.getImage());
	Manager manager = users
		.getReferenceById(inputs.getUserId());
	entity.setManager(manager);
	Quiz newQuiz = quizzes.save(entity);
	Long quizId = newQuiz.getId();
	for (QuestionCreateDto question : inputs
		.getQuestions()) {
	    this.questionServices.create(question, quizId);
	}

    }

    @Override
    public Collection<QuizForListDto> getAll() {
	return quizzes.findAllProjectedBy();
    }

    @Override
    public QuizVueDto quizVue(Long id) {
	Quiz entity = quizzes.getReferenceById(id);
	QuizVueDto quiz = new QuizVueDto();
	quiz.setId(id);
	quiz.setImage(entity.getImage());
	quiz.setName(entity.getName());
	quiz.setUserName(entity.getManager().getName());
	List<QuestionVueDto> questions = questionServices
		.vueQuestion(id);
	quiz.setQuestions(questions);
	return quiz;
    }

    @Override
    @Transactional
    public void update(Long id, QuizUpdateDto inputs) {
	Quiz entity = quizzes.findById(id).get();
	entity.setName(inputs.name());
	entity.setImage(inputs.image());
	this.questionServices.delete(id);
	for (QuestionCreateDto question : inputs
		.questions()) {
	    this.questionServices.create(question, id);
	}
	quizzes.save(entity);
    }

    @Override
    public List<Long> quizIdsByManager(Long managerId) {
	List<Long> quizIdsByManager = quizzes
		.findAllByManager(managerId);
	return quizIdsByManager;
    }

    @Override
    @Transactional
    public void delete(Long id) {
	quizzes.deleteById(id);
    }

    public ResultQuizToReturnDto questionSubmit(
	    QuizPlayedResultsDto results) {
	ResultQuizToReturnDto resultToReturn = new ResultQuizToReturnDto(
		null);
	return resultToReturn;
    }

    @Override
    public boolean nameValueExists(String name)
	    throws UnsupportedOperationException {
	return this.quizzes.existsByName(name.toString());
    }

    @Override
    public boolean userIdValueExists(Long userId)
	    throws UnsupportedOperationException {
	return this.quizzes.existsByManagerId(userId);
    }
}
