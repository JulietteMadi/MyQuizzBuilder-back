package co.simplon.myquizzbuilder.services;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.simplon.myquizzbuilder.config.AuthHelper;
import co.simplon.myquizzbuilder.dtos.CredentialsSignIn;
import co.simplon.myquizzbuilder.dtos.CredentialsSignUp;
import co.simplon.myquizzbuilder.dtos.TokenInfo;
import co.simplon.myquizzbuilder.entities.User;
import co.simplon.myquizzbuilder.repositories.UserRepository;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {
    private final UserRepository users;
    private final AuthHelper authHelper;

    public UserServiceImpl(UserRepository users,
	    AuthHelper authHelper) {
	this.users = users;
	this.authHelper = authHelper;
    }

    @Override
    @Transactional
    public void signUp(CredentialsSignUp inputs) {
	String mail = inputs.getEmail();
	User existingAccount = users.findOneByEmail(mail);
	if (existingAccount != null) {
	    throw new BadCredentialsException(
		    "This email already exists");
	}

	User user = new User();
	String password = inputs.getPassword();
	String hash = authHelper.encode(password);
	user.setPassword(hash);
	user.setEmail(mail);
	user.setName(inputs.getName());
	users.save(user);
    }

    @Override
    public TokenInfo signIn(CredentialsSignIn inputs) {
	User candidate = users.findOneByEmailOrName(
		inputs.getEmailOrUsername(),
		inputs.getEmailOrUsername());
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
	TokenInfo tokenInfo = new TokenInfo();
	String token = authHelper
		.createJWT(candidate.getName());
	tokenInfo.setToken(token);
	return tokenInfo;
    }
}
