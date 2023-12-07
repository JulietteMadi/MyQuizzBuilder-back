package co.simplon.myquizzbuilder.dtos.quiz;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class QuestionCreateDto {

    @NotBlank
    @Size(max = 255)
    private String name;

    @NotBlank
    @Size(max = 1000)
    private String answerDescription;

    @NotEmpty
    @Size(min = 2, max = 10)
    private List<@Valid AvailableAnswerCreateDto> answers;

    @NotNull
    private Integer topicId;

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getAnswerDescription() {
	return answerDescription;
    }

    public void setAnswerDescription(
	    String answerDescription) {
	this.answerDescription = answerDescription;
    }

    public List<AvailableAnswerCreateDto> getAnswers() {
	return answers;
    }

    public void setAnswers(
	    List<AvailableAnswerCreateDto> answers) {
	this.answers = answers;
    }

    public Integer getTopicId() {
	return topicId;
    }

    public void setTopicId(Integer topicId) {
	this.topicId = topicId;
    }

    @Override
    public String toString() {
	return "{name=" + name + ", answerDescription="
		+ answerDescription + ", answers=" + answers
		+ ", topicId=" + topicId + "}";
    }
}
