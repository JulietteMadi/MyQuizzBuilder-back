package co.simplon.myquizzbuilder.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ConditionalOnProperty(value = "auth-api.cors.enabled", havingValue = "true", matchIfMissing = true)
public class CustomWebMvcConfigurer
	implements WebMvcConfigurer {

    @Value("${auth-api.cors.allowedOrigins}")
    private String[] allowedOrigins;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
	registry.addMapping("/**")
		.allowedOrigins(allowedOrigins)
		.allowedMethods("POST", "GET", "PATCH",
			"PUT", "DELETE");
    }

}
