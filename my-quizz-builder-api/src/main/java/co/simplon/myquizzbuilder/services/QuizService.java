package co.simplon.myquizzbuilder.services;

import java.util.Collection;
import java.util.List;

import co.simplon.myquizzbuilder.dtos.quiz.QuizCreateDto;
import co.simplon.myquizzbuilder.dtos.quiz.QuizForListDto;
import co.simplon.myquizzbuilder.dtos.quiz.QuizUpdateDto;
import co.simplon.myquizzbuilder.dtos.quiz.QuizVueDto;

public interface QuizService {
    void create(QuizCreateDto inputs);

    Collection<QuizForListDto> getAll();

    QuizVueDto quizVue(Long id);

    void delete(Long id);

    public List<Long> quizIdsByManager(Long managerId);

    void update(Long id, QuizUpdateDto inputs);
}
