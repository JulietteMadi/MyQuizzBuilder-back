package co.simplon.myquizzbuilder.dtos;

public class UserInfoDto {

    private String token;

    private String userName;

    private String userEmail;

    public String getToken() {
	return token;
    }

    public void setToken(String token) {
	this.token = token;
    }

    public String getUserName() {
	return userName;
    }

    public void setUserName(String userName) {
	this.userName = userName;
    }

    public String getUserEmail() {
	return userEmail;
    }

    public void setUserEmail(String userEmail) {
	this.userEmail = userEmail;
    }

    @Override
    public String toString() {
	return "{token=" + token + ", userName=" + userName
		+ ", userEmail=" + userEmail + "}";
    }

}
