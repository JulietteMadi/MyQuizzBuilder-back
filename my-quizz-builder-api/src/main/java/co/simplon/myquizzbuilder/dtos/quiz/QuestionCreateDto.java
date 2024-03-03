package co.simplon.myquizzbuilder.dtos.quiz;

import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class QuestionCreateDto {

    @NotBlank
    @Size(max = 255)
    private String name;

    @NotNull
    private Long questionIndex;

    @NotBlank
    @Size(max = 1000)
    private String answerDescription;

    @NotEmpty
    @Size(min = 2, max = 10)
    private List<@Valid AnswerCreateDto> answers;

    @NotNull
    private Long topicId;

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public Long getQuestionIndex() {
	return questionIndex;
    }

    public void setQuestionIndex(Long questionIndex) {
	this.questionIndex = questionIndex;
    }

    public String getAnswerDescription() {
	return answerDescription;
    }

    public void setAnswerDescription(
	    String answerDescription) {
	this.answerDescription = answerDescription;
    }

    public List<AnswerCreateDto> getAnswers() {
	return answers;
    }

    public void setAnswers(
	    List<AnswerCreateDto> answers) {
	this.answers = answers;
    }

    public Long getTopicId() {
	return topicId;
    }

    public void setTopicId(Long topicId) {
	this.topicId = topicId;
    }

    @Override
    public String toString() {
	return "{name=" + name + ", questionIndex="
		+ questionIndex + ", answerDescription="
		+ answerDescription + ", answers=" + answers
		+ ", topicId=" + topicId + "}";
    }

}
