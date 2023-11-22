package co.simplon.myquizzbuilder.controllers;

import java.util.Collection;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.myquizzbuilder.dtos.GuideVueDto;
import co.simplon.myquizzbuilder.services.GuideService;

@RestController
@RequestMapping("/guides")
public class GuideController {

    private final GuideService service;

    public GuideController(GuideService service) {
	this.service = service;
    }

    @GetMapping
    public Collection<GuideVueDto> getAll() {
	return service.getAll();
    }

}
