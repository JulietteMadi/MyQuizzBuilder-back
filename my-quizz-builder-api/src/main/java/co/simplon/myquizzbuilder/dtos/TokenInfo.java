package co.simplon.myquizzbuilder.dtos;

public class TokenInfo {

    private String token;

    private String subject;

    public String getToken() {
	return token;
    }

    public void setToken(String token) {
	this.token = token;
    }

    public String getSubject() {
	return subject;
    }

    public void setSubject(String subject) {
	this.subject = subject;
    }

    @Override
    public String toString() {
	return "{token=" + token + ", subject=" + subject
		+ "}";
    }

}
