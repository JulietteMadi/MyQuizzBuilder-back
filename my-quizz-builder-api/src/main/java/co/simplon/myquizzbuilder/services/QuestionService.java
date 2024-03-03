package co.simplon.myquizzbuilder.services;

import java.util.List;

import co.simplon.myquizzbuilder.dtos.quiz.QuestionCreateDto;
import co.simplon.myquizzbuilder.dtos.quiz.QuestionVueDto;

public interface QuestionService {
    void create(QuestionCreateDto inputs, Long quizId);

    void delete(Long questionId);

    public List<QuestionVueDto> vueQuestion(Long quizId);
}
