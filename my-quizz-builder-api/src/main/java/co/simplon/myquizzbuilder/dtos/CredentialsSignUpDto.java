package co.simplon.myquizzbuilder.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import co.simplon.myquizzbuilder.customValidations.UniqueUserEmail;
import co.simplon.myquizzbuilder.customValidations.UniqueUserName;

public class CredentialsSignUpDto {

    @Email
    @NotBlank
    @UniqueUserEmail
    private String email;

    @NotBlank
    @Length(min = 4, max = 20)
    @UniqueUserName
    private String name;

    @NotBlank
    @Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[%||!||*])(?!.* ).{8,42}")
    private String password;

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getPassword() {
	return password;
    }

    public void setPassword(String password) {
	this.password = password;
    }

    @Override
    public String toString() {
	return "{email=" + email + ", name=" + name
		+ ", password=" + password + "}";
    }

}
