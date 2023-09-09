package co.simplon.myquizzbuilder.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.auth0.jwt.algorithms.Algorithm;

@Configuration
public class SecurityConfig {

    @Value("${mqb.auth.rounds}")
    private int rounds;
    @Value("${mqb.auth.issuer}")
    private String issuer;
    @Value("${mqb.auth.secret}")
    private String secret;
    @Value("${mqb.auth.tokenExpiration}")
    private long tokenExpiration;

    @Bean
    public AuthHelper authHelper() {
	Algorithm algorithm = Algorithm.HMAC256(secret);
	PasswordEncoder encoder = new BCryptPasswordEncoder(
		rounds);

	return new AuthHelper.Builder().algorithm(algorithm)
		.encoder(encoder)
		.expiration(tokenExpiration).issuer(issuer)
		.build();
    }
}
