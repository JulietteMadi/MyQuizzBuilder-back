package co.simplon.myquizzbuilder.dtos.quiz;

import java.util.List;

public interface QuestionVueDto {
    String getName();

    String getAnswerDescription();

    List<AnswerVueDto> getAnswers();
}
