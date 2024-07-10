package co.simplon.myquizzbuilder;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
class Tokens {

    @Value("${mqb.tests.fake-token}")
    private String fake;

    @Value("${mqb.tests.bad-secret-token}")
    private String badSecret;

    @Value("${mqb.tests.bad-issuer-token}")
    private String badIssuer;

    @Value("${mqb.tests.expired-token}")
    private String expired;

    @Value("${mqb.tests.valid-token}")
    private String valid;

    String get(final String name) {
	switch (name) {
	case "fake":
	    return fake;
	case "badSecret":
	    return badSecret;
	case "badIssuer":
	    return badIssuer;
	case "expired":
	    return expired;
	case "validToken":
	    return valid;
	default:
	    throw new IllegalArgumentException(
		    "Unexpected value: " + name);
	}
    }

}
