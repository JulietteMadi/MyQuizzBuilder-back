package co.simplon.myquizzbuilder.controllers;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.myquizzbuilder.dtos.GuideCreateDto;
import co.simplon.myquizzbuilder.dtos.GuideVueDto;
import co.simplon.myquizzbuilder.services.GuideService;

@RestController
@RequestMapping("/guides")
public class GuideController {

    private final GuideService service;

    public GuideController(GuideService service) {
	this.service = service;
    }

    public void create(
	    @RequestBody @Valid GuideCreateDto inputs) {
	service.createGuide(inputs);
    };

    @GetMapping
    public Collection<GuideVueDto> getAll() {
	return service.getAll();
    }

}
