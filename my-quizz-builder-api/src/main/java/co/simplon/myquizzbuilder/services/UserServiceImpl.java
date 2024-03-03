package co.simplon.myquizzbuilder.services;

import java.util.List;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.simplon.myquizzbuilder.config.AuthHelper;
import co.simplon.myquizzbuilder.dtos.manager.CredentialsSignInDto;
import co.simplon.myquizzbuilder.dtos.manager.CredentialsSignUpDto;
import co.simplon.myquizzbuilder.dtos.manager.ManagerInfoDto;
import co.simplon.myquizzbuilder.dtos.manager.ManagerItemsVueDto;
import co.simplon.myquizzbuilder.entities.Manager;
import co.simplon.myquizzbuilder.repositories.UserRepository;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {
    private final UserRepository users;
    private final AuthHelper authHelper;
    private final QuizService quizzes;

    public UserServiceImpl(UserRepository users,
	    AuthHelper authHelper, QuizService quizzes) {
	this.users = users;
	this.authHelper = authHelper;
	this.quizzes = quizzes;
    }

    @Override
    @Transactional
    public void signUp(CredentialsSignUpDto inputs) {
	String mail = inputs.getEmail();
	Manager existingAccount = users
		.findOneByEmail(mail);
	if (existingAccount != null) {
	    throw new BadCredentialsException(
		    "This email already exists");
	}

	Manager user = new Manager();
	String password = inputs.getPassword();
	String hash = authHelper.encode(password);
	user.setPassword(hash);
	user.setEmail(mail);
	user.setName(inputs.getName());
	users.save(user);
    }

    @Override
    public ManagerInfoDto signIn(
	    CredentialsSignInDto inputs) {
	Manager candidate = users.findOneByEmail(
		inputs.getEmailOrUsername());
	if (candidate == null) {
	    candidate = users.findOneByName(
		    inputs.getEmailOrUsername());
	}
	if (candidate == null) {
	    throw new BadCredentialsException(
		    "Wrong credentials");
	}
	boolean match = authHelper.matches(
		inputs.getPassword(),
		candidate.getPassword());
	if (!match) {
	    throw new BadCredentialsException(
		    "Wrong credentials");
	}
	ManagerInfoDto tokenInfo = new ManagerInfoDto();
	String token = authHelper
		.createJWT(candidate.getName());
	tokenInfo.setToken(token);
	tokenInfo.setUserName(candidate.getName());
	tokenInfo.setUserEmail(candidate.getEmail());
	tokenInfo.setId(candidate.getId());
	return tokenInfo;
    }

    @Override
    public ManagerItemsVueDto getManagerItems(Long id) {
	List<Long> quizIds = quizzes.quizIdsByManager(id);
	ManagerItemsVueDto managerItems = new ManagerItemsVueDto();
	managerItems.setQuizIds(quizIds);
	System.out.println(managerItems);
	return managerItems;
    }

    @Override
    public boolean nameValueExists(String name)
	    throws UnsupportedOperationException {
	return this.users.existsByName(name.toString());
    }

    @Override
    public boolean emailValueExists(String email)
	    throws UnsupportedOperationException {
	return this.users.existsByEmail(email.toString());
    }

}
