package co.simplon.myquizzbuilder.controllers;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.myquizzbuilder.dtos.CredentialsSignInDto;
import co.simplon.myquizzbuilder.dtos.CredentialsSignUpDto;
import co.simplon.myquizzbuilder.dtos.UserInfoDto;
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
	    @RequestBody @Valid CredentialsSignUpDto inputs) {
	userService.signUp(inputs);
    }

    @PostMapping("/sign-in")
    public UserInfoDto signIn(
	    @RequestBody CredentialsSignInDto inputs) {
	return userService.signIn(inputs);
    }

}
