package co.simplon.myquizzbuilder.dtos.quiz;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AvailableAnswerCreateDto {

    @NotEmpty
    @Size(max = 255)
    private String name;

    @NotNull
    private Boolean valid;

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

    @Override
    public String toString() {
	return "{name=" + name + ", valid=" + valid + "}";
    }
}
