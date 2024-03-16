package co.simplon.myquizzbuilder.controllers;

import java.util.Collection;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.myquizzbuilder.dtos.quiz.QuizCreateDto;
import co.simplon.myquizzbuilder.dtos.quiz.QuizForListDto;
import co.simplon.myquizzbuilder.dtos.quiz.QuizPlayedResultsDto;
import co.simplon.myquizzbuilder.dtos.quiz.QuizUpdateDto;
import co.simplon.myquizzbuilder.dtos.quiz.QuizVueDto;
import co.simplon.myquizzbuilder.services.QuizService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/quizzes")
public class QuizController {
    private final QuizService service;

    public QuizController(QuizService service) {
	this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void create(
	    @RequestBody @Valid QuizCreateDto inputs) {
	service.create(inputs);
    }

    @GetMapping("/{id}")
    public QuizVueDto quizVue(@PathVariable("id") Long id) {
	System.out.println(service.quizVue(id));
	return service.quizVue(id);
    }

    @GetMapping
    public Collection<QuizForListDto> getAll() {
	return service.getAll();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id) {
	service.delete(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable("id") Long id,
	    @RequestBody QuizUpdateDto inputs) {
	service.update(id, inputs);
    }

    public void questionSubmit(
	    @RequestBody @Valid QuizPlayedResultsDto quizResults) {
	// return null;
    }
}
