package co.simplon.myquizzbuilder.dtos.manager;

public class ManagerInfoDto {

    private String token;

    private String userName;

    private String userEmail;

    private Long id;

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

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    @Override
    public String toString() {
	return "{token=" + token + ", userName=" + userName
		+ ", userEmail=" + userEmail + ", id=" + id
		+ "}";
    }

}
