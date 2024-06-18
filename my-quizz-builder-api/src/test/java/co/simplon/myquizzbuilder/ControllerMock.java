package co.simplon.myquizzbuilder;

import org.mockito.Mockito;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import co.simplon.myquizzbuilder.controllers.UserController;

@TestConfiguration
public class ControllerMock {
    @Bean
    UserController userController() {
	return Mockito.mock(UserController.class);
    }

}
