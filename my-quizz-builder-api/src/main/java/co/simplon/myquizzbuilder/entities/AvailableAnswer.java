package co.simplon.myquizzbuilder.entities;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "available_answers")
public class AvailableAnswer extends AbstractEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "valid")
    private Boolean valid;

    @Column(name = "answer_index")
    private Long answerIndex;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public Boolean getValid() {
	return valid;
    }

    public void setValid(Boolean valid) {
	this.valid = valid;
    }

    public Long getAnswerIndex() {
	return answerIndex;
    }

    public void setAnswerIndex(Long answerIndex) {
	this.answerIndex = answerIndex;
    }

    public Question getQuestion() {
	return question;
    }

    public void setQuestion(Question question) {
	this.question = question;
    }

    @Override
    public int hashCode() {
	return Objects.hash(answerIndex, question);
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj) {
	    return true;
	}
	if (!(obj instanceof AvailableAnswer)) {
	    return false;
	}
	AvailableAnswer other = (AvailableAnswer) obj;
	return Objects.equals(answerIndex,
		other.answerIndex)
		&& Objects.equals(question, other.question);
    }

    @Override
    public String toString() {
	return "{name=" + name + ", valid=" + valid
		+ ", answerIndex=" + answerIndex
		+ ", question=" + question + "}";
    }

}
