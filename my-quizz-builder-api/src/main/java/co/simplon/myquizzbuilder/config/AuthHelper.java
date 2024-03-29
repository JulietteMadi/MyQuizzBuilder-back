package co.simplon.myquizzbuilder.config;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;

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

    public String createJWT(String name, Long id) {
	Instant now = Instant.now();
	Instant expirationTime = now
		.plusSeconds(expiration);
	return JWT.create().withIssuer(issuer)
		.withSubject(name).withIssuedAt(now)
		.withExpiresAt(expirationTime)
		.withClaim("userId", id).sign(algorithm);
    }

    public Map<String, Object> getPrincipalInfo(
	    JwtAuthenticationToken principal) {

	Map<String, Object> info = new HashMap<>();
	Map<String, Object> tokenAttributes = principal
		.getTokenAttributes();
	Long userId = (Long) tokenAttributes.get("userId");
	info.put("userId", userId);
	info.put("tokenAttributes",
		principal.getTokenAttributes());
	return info;
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
