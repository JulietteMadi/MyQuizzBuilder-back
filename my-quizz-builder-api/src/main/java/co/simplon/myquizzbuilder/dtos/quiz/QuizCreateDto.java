package co.simplon.myquizzbuilder.dtos.quiz;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class QuizCreateDto {
    @NotBlank
    @Size(max = 100)
    private String name;

    @NotBlank
    private String image;

    @NotNull
    private Integer userId;

    @NotEmpty
    @Size(min = 5, max = 50)
    private List<@Valid QuizCreateDto> questions;
}
