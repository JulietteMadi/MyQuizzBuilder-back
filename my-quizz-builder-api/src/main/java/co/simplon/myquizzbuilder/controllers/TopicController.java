package co.simplon.myquizzbuilder.controllers;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.myquizzbuilder.dtos.TopicDetailDto;
import co.simplon.myquizzbuilder.dtos.TopicCreateDto;
import co.simplon.myquizzbuilder.dtos.TopicForUpdateDto;
import co.simplon.myquizzbuilder.services.TopicService;

@CrossOrigin
@RestController
@RequestMapping("/topics")
public class TopicController {

    private final TopicService service;

    public TopicController(TopicService service) {
	this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void create(
	    @RequestBody @Valid TopicCreateDto inputs) {
	service.createTopic(inputs);
    }

    @GetMapping("/{id}")
    public TopicDetailDto topicDetail(
	    @PathVariable("id") Long id) {
	return service.topicDetail(id);
    }

    @GetMapping
    public java.util.Collection<TopicForUpdateDto> getAll() {
	return service.getAll();

    }

}
