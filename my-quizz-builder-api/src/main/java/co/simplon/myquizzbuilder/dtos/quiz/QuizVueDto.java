package co.simplon.myquizzbuilder.dtos.quiz;

import java.util.List;

public class QuizVueDto {
    private Long id;

    private String name;

    private String image;

    private String userName;

    private List<QuestionVueDto> questions;

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getImage() {
	return image;
    }

    public void setImage(String image) {
	this.image = image;
    }

    public String getUserName() {
	return userName;
    }

    public void setUserName(String userName) {
	this.userName = userName;
    }

    public List<QuestionVueDto> getQuestions() {
	return questions;
    }

    public void setQuestions(
	    List<QuestionVueDto> questions) {
	this.questions = questions;
    }

    @Override
    public String toString() {
	return "{id=" + id + ", name=" + name + ", image="
		+ image + ", userName=" + userName
		+ ", questions=" + questions + "}";
    }

}
