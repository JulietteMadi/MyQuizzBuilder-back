package co.simplon.myquizzbuilder.controllers;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.myquizzbuilder.dtos.CredentialsSignIn;
import co.simplon.myquizzbuilder.dtos.CredentialsSignUp;
import co.simplon.myquizzbuilder.dtos.TokenInfo;
import co.simplon.myquizzbuilder.services.UserService;

@RestController
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
	this.userService = userService;
    }

    @PostMapping("/sign-up")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void signUp(
	    @RequestBody @Valid CredentialsSignUp inputs) {
	userService.signUp(inputs);
    }

    @PostMapping("/sign-in")
    public TokenInfo signIn(
	    @RequestBody CredentialsSignIn inputs) {
	return userService.signIn(inputs);
    }

    @GetMapping("/test")
    public String test() {
	return "works";
    }
}
