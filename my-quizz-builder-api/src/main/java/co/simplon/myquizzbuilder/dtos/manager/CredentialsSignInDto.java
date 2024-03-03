package co.simplon.myquizzbuilder.dtos.manager;

import jakarta.validation.constraints.NotBlank;

public class CredentialsSignInDto {

    @NotBlank
    private String emailOrUsername;

    @NotBlank
    private String password;

    public String getEmailOrUsername() {
	return emailOrUsername;
    }

    public void setEmailOrUsername(String emailOrUsername) {
	this.emailOrUsername = emailOrUsername;
    }

    public String getPassword() {
	return password;
    }

    public void setPassword(String password) {
	this.password = password;
    }

    @Override
    public String toString() {
	return "{emailOrUsername=" + emailOrUsername
		+ ", password=" + password + "}";
    }

}
