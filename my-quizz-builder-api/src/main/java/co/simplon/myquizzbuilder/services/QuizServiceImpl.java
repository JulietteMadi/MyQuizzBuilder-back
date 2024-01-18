package co.simplon.myquizzbuilder.services;

import java.util.Collection;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.simplon.myquizzbuilder.dtos.quiz.QuestionCreateDto;
import co.simplon.myquizzbuilder.dtos.quiz.QuizCreateDto;
import co.simplon.myquizzbuilder.dtos.quiz.QuizForListDto;
import co.simplon.myquizzbuilder.dtos.quiz.QuizVueDto;
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
	QuizVueDto quiz = quizzes.findProjectDetailById(id);
	System.out.println(quiz);
	return quiz;
    }

    @Override
    @Transactional
    public void delete(Long id) {
	quizzes.deleteById(id);
    }
}
