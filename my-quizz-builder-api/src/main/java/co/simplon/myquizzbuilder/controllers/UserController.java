package co.simplon.myquizzbuilder.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.myquizzbuilder.dtos.manager.CredentialsSignInDto;
import co.simplon.myquizzbuilder.dtos.manager.CredentialsSignUpDto;
import co.simplon.myquizzbuilder.dtos.manager.ManagerInfoDto;
import co.simplon.myquizzbuilder.dtos.manager.ManagerItemsVueDto;
import co.simplon.myquizzbuilder.services.UserService;
import jakarta.validation.Valid;

@RestController
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
	this.userService = userService;
    }

    @PostMapping("/sign-up")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void signUp(
	    @RequestBody @Valid CredentialsSignUpDto inputs) {
	userService.signUp(inputs);
    }

    @PostMapping("/sign-in")
    public ManagerInfoDto signIn(
	    @RequestBody CredentialsSignInDto inputs) {
	return userService.signIn(inputs);
    }

    @GetMapping("/items/{id}")
    public ManagerItemsVueDto managerItemsVue(
	    @PathVariable("id") Long id) {
	return userService.getManagerItems(id);
    }

}
