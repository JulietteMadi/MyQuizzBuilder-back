package co.simplon.myquizzbuilder.dtos.quiz;

import java.util.List;

public class QuestionVueDto {
    private String name;

    private String answerDescription;

    private Long topicId;

    private List<AnswerVueDto> answers;

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

    public Long getTopicId() {
	return topicId;
    }

    public void setTopicId(Long topicId) {
	this.topicId = topicId;
    }

    public List<AnswerVueDto> getAnswers() {
	return answers;
    }

    public void setAnswers(List<AnswerVueDto> answers) {
	this.answers = answers;
    }

    @Override
    public String toString() {
	return "{name=" + name + ", answerDescription="
		+ answerDescription + ", topicId=" + topicId
		+ ", answers=" + answers + "}";
    }

}
