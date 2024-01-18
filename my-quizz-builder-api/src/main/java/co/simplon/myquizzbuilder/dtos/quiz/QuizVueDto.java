package co.simplon.myquizzbuilder.dtos.quiz;

import java.util.List;

public interface QuizVueDto {
    Long getId();

    String getName();

    String getImage();

    List<QuestionVueDto> getQuestions();
}
