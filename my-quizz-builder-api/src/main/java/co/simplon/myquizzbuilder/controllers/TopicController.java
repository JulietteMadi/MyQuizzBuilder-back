package co.simplon.myquizzbuilder.controllers;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.myquizzbuilder.dtos.TopicCreate;
import co.simplon.myquizzbuilder.services.TopicService;

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
	    @RequestBody @Valid TopicCreate inputs) {
	service.createTopic(inputs);
    }

}
