package co.simplon.myquizzbuilder.dtos.quiz;

import java.util.List;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class QuizPlayDto {

    @NotEmpty
    private List<Boolean> answersResults;

    @NotNull
    private Long quizId;

    public List<Boolean> getAnswersResults() {
	return answersResults;
    }

    public void setAnswersResults(
	    List<Boolean> answersResults) {
	this.answersResults = answersResults;
    }

    public Long getQuizId() {
	return quizId;
    }

    public void setQuizId(Long quizId) {
	this.quizId = quizId;
    }

    @Override
    public String toString() {
	return "{answersResults=" + answersResults
		+ ", quizId=" + quizId + "}";
    }

}
