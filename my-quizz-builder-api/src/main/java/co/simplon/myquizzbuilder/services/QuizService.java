package co.simplon.myquizzbuilder.services;

import java.util.Collection;

import co.simplon.myquizzbuilder.dtos.quiz.QuizCreateDto;
import co.simplon.myquizzbuilder.dtos.quiz.QuizForListDto;
import co.simplon.myquizzbuilder.dtos.quiz.QuizVueDto;

public interface QuizService {
    void create(QuizCreateDto inputs);

    Collection<QuizForListDto> getAll();

    QuizVueDto quizVue(Long id);

    void delete(Long id);
}
