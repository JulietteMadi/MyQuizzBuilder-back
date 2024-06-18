package co.simplon.myquizzbuilder.controllers;

import java.util.Collection;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.myquizzbuilder.config.AuthHelper;
import co.simplon.myquizzbuilder.dtos.quiz.QuizCreateDto;
import co.simplon.myquizzbuilder.dtos.quiz.QuizForListDto;
import co.simplon.myquizzbuilder.dtos.quiz.QuizPlayDto;
import co.simplon.myquizzbuilder.dtos.quiz.QuizResultsDto;
import co.simplon.myquizzbuilder.dtos.quiz.QuizUpdateDto;
import co.simplon.myquizzbuilder.dtos.quiz.QuizVueDto;
import co.simplon.myquizzbuilder.services.QuizService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/quizzes")
public class QuizController {
    private final QuizService service;
    private final AuthHelper authHelper;

    public QuizController(QuizService service,
	    AuthHelper authHelper) {
	this.service = service;
	this.authHelper = authHelper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void create(
	    @RequestBody @Valid QuizCreateDto inputs,
	    JwtAuthenticationToken token) {
	Map<String, Object> user = authHelper
		.getPrincipalInfo(token);
	Long userId = (Long) user.get("userId");
	service.create(inputs, userId);
    }

    @PostMapping("/{id}/play-quiz")
    public QuizResultsDto quizSubmit(
	    @RequestBody @Valid QuizPlayDto quizAnswers,
	    @PathVariable("id") Long id) {
	return service.quizCorrect(quizAnswers, id);
    }

    @GetMapping("/{id}")
    public QuizVueDto quizVue(@PathVariable("id") Long id) {
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
}
