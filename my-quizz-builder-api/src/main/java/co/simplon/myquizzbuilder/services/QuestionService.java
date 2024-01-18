package co.simplon.myquizzbuilder.services;

import co.simplon.myquizzbuilder.dtos.quiz.QuestionCreateDto;

public interface QuestionService {
    void create(QuestionCreateDto inputs, Long quizId);
}
