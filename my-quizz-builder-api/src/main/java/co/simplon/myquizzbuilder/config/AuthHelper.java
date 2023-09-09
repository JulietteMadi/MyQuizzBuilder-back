package co.simplon.myquizzbuilder.config;

import java.time.Instant;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

public class AuthHelper {
    private final String issuer;
    private final long expiration;
    private final Algorithm algorithm;
    private final PasswordEncoder encoder;

    public AuthHelper(Builder builder) {
	this.issuer = builder.issuer;
	this.algorithm = builder.algorithm;
	this.encoder = builder.encoder;
	this.expiration = builder.expiration;
    }

    public String encode(String password) {
	return encoder.encode(password);
    }

    public Boolean matches(String candidate, String hash) {
	return encoder.matches(candidate, hash);
    }

    public String createJWT(String name) {
	Instant now = Instant.now();
	Instant expirationTime = now
		.plusSeconds(expiration);
	return JWT.create().withIssuer(issuer)
		.withSubject(name).withIssuedAt(now)
		.withExpiresAt(expirationTime)
		.sign(algorithm);
    }

    public static class Builder {
	private String issuer;
	private long expiration;
	private Algorithm algorithm;
	private PasswordEncoder encoder;

	public Builder() {

	}

	public Builder issuer(String issuer) {
	    this.issuer = issuer;
	    return this;
	}

	public Builder algorithm(Algorithm algorithm) {
	    this.algorithm = algorithm;
	    return this;
	}

	public Builder expiration(long expiration) {
	    this.expiration = expiration;
	    return this;
	}

	public Builder encoder(PasswordEncoder encoder) {
	    this.encoder = encoder;
	    return this;
	}

	public AuthHelper build() {
	    return new AuthHelper(this);
	}
    }
}