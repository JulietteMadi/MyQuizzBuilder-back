package co.simplon.myquizzbuilder.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "available_answers")
public class AvailableAnswer extends AbstractEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "valid")
    private Boolean valid;

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

    public Question getQuestion() {
	return question;
    }

    public void setQuestion(Question question) {
	this.question = question;
    }

    @Override
    public String toString() {
	return "{name=" + name + ", valid=" + valid
		+ ", question=" + question + "}";
    }
}
