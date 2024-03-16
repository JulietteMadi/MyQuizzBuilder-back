package co.simplon.myquizzbuilder.services;

import co.simplon.myquizzbuilder.dtos.manager.CredentialsSignInDto;
import co.simplon.myquizzbuilder.dtos.manager.CredentialsSignUpDto;
import co.simplon.myquizzbuilder.dtos.manager.ManagerInfoDto;
import co.simplon.myquizzbuilder.dtos.manager.ManagerItemsVueDto;

public interface UserService {
    public void signUp(CredentialsSignUpDto credentials);

    public ManagerInfoDto signIn(
	    CredentialsSignInDto inputs);

    public ManagerItemsVueDto getManagerItems(Long id);

    public boolean nameValueExists(String name);

    public boolean emailValueExists(String email);

}
