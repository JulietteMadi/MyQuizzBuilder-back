package co.simplon.myquizzbuilder.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Override
    public ResultQuizToReturnDto questionSubmit(
	    QuizPlayedResultsDto results) {
	List<QuestionVueDto> questions = questionServices
		.vueQuestion(results.quizId());
	List<Long> topicsId = new ArrayList<Long>();
	for (QuestionVueDto question : questions) {
	    topicsId.add(question.getTopicId());
	}
	Map<Long, List<Boolean>> resultMap = resultsByTopicId(
		results.answersResults(), topicsId);
	int minScore = 100;
	Long topicIdMinScore = null;
	for (Map.Entry<Long, List<Boolean>> entry : resultMap
		.entrySet()) {
	    int score = score(entry.getValue());
	    if (score < minScore) {
		minScore = score;
		topicIdMinScore = entry.getKey();
	    }
	}
	int totalScore = score(results.answersResults());
	ResultQuizToReturnDto resultToReturn = new ResultQuizToReturnDto(
		totalScore, topicIdMinScore);
	return resultToReturn;
    }

    public static Map<Long, List<Boolean>> resultsByTopicId(
	    List<Boolean> results, List<Long> topicIds) {
	Map<Long, List<Boolean>> resultMap = new HashMap<>();
	for (int i = 0; i < results.size(); i++) {
	    Long topicId = topicIds.get(i);
	    boolean result = results.get(i);
	    resultMap.putIfAbsent(topicId,
		    new ArrayList<>());
	    resultMap.get(topicId).add(result);
	}
	return resultMap;
    }

    public static int score(List<Boolean> results) {
	int score = 0;
	for (Boolean result : results) {
	    if (result) {
		score++;
	    }
	}
	double ratio = ((double) score / results.size())
		* 100;
	return (int) ratio;
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
