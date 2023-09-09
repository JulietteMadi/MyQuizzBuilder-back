package co.simplon.myquizzbuilder.services;

import co.simplon.myquizzbuilder.dtos.CredentialsSignIn;
import co.simplon.myquizzbuilder.dtos.CredentialsSignUp;
import co.simplon.myquizzbuilder.dtos.TokenInfo;

public interface UserService {
    public void signUp(CredentialsSignUp credentials);

    public TokenInfo signIn(CredentialsSignIn inputs);
}
