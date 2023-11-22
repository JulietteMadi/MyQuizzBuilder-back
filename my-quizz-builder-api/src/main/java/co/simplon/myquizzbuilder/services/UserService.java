package co.simplon.myquizzbuilder.services;

import co.simplon.myquizzbuilder.dtos.CredentialsSignInDto;
import co.simplon.myquizzbuilder.dtos.CredentialsSignUpDto;
import co.simplon.myquizzbuilder.dtos.UserInfoDto;

public interface UserService {
    public void signUp(CredentialsSignUpDto credentials);

    public UserInfoDto signIn(CredentialsSignInDto inputs);

    public boolean nameValueExists(String name);

    public boolean emailValueExists(String email);
}
