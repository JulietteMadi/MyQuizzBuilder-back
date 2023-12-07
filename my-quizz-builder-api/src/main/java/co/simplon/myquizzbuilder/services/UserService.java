package co.simplon.myquizzbuilder.services;

import co.simplon.myquizzbuilder.dtos.user.CredentialsSignInDto;
import co.simplon.myquizzbuilder.dtos.user.CredentialsSignUpDto;
import co.simplon.myquizzbuilder.dtos.user.UserInfoDto;

public interface UserService {
    public void signUp(CredentialsSignUpDto credentials);

    public UserInfoDto signIn(CredentialsSignInDto inputs);

    public boolean nameValueExists(String name);

    public boolean emailValueExists(String email);
}
