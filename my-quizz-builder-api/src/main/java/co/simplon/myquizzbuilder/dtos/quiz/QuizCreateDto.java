package co.simplon.myquizzbuilder.dtos.quiz;

import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class QuizCreateDto {
    @NotBlank
    @Size(max = 100)
    private String name;

    @NotBlank
    private String image;

    @NotNull
    private Long userId;

    @NotEmpty
    @Size(min = 5, max = 50)
    private List<@Valid QuestionCreateDto> questions;

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

    public Long getUserId() {
	return userId;
    }

    public void setUserId(Long userId) {
	this.userId = userId;
    }

    public List<QuestionCreateDto> getQuestions() {
	return questions;
    }

    public void setQuestions(
	    List<QuestionCreateDto> questions) {
	this.questions = questions;
    }

    @Override
    public String toString() {
	return "{name=" + name + ", image=" + image
		+ ", userId=" + userId + ", questions="
		+ questions + "}";
    }

}
