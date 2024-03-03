package co.simplon.myquizzbuilder.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "questions")
public class Question extends AbstractEntity {
    @Column(name = "name")
    private String name;

    @Column(name = "question_index")
    private Long questionIndex;

    @Column(name = "answer_description")
    private String answerDescription;

    @ManyToOne
    @JoinColumn(name = "topic_id")
    private Topic topic;

    @ManyToOne
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;

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

    public Topic getTopic() {
	return topic;
    }

    public void setTopic(Topic topic) {
	this.topic = topic;
    }

    public Quiz getQuiz() {
	return quiz;
    }

    public void setQuiz(Quiz quiz) {
	this.quiz = quiz;
    }

    @Override
    public String toString() {
	return "{name=" + name + ", questionIndex="
		+ questionIndex + ", answerDescription="
		+ answerDescription + ", topic=" + topic
		+ ", quiz=" + quiz + "}";
    }

}
