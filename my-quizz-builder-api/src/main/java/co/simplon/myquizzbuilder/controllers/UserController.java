package co.simplon.myquizzbuilder.controllers;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.myquizzbuilder.config.AuthHelper;
import co.simplon.myquizzbuilder.dtos.manager.CredentialsSignInDto;
import co.simplon.myquizzbuilder.dtos.manager.CredentialsSignUpDto;
import co.simplon.myquizzbuilder.dtos.manager.ManagerInfoDto;
import co.simplon.myquizzbuilder.dtos.manager.ManagerItemsVueDto;
import co.simplon.myquizzbuilder.services.UserService;
import jakarta.validation.Valid;

@RestController
public class UserController {
    private UserService userService;
    private AuthHelper authHelper;

    public UserController(UserService userService,
	    AuthHelper authHelper) {
	this.userService = userService;
	this.authHelper = authHelper;
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

    @GetMapping("/items")
    public ManagerItemsVueDto managerItemsVue(
	    JwtAuthenticationToken token) {
	Map<String, Object> user = authHelper
		.getPrincipalInfo(token);
	Long userId = (Long) user.get("userId");
	return userService.getManagerItems(userId);
    }
}
