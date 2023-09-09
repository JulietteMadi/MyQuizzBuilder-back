package co.simplon.myquizzbuilder.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import co.simplon.myquizzbuilder.entities.User;

public interface UserRepository
	extends JpaRepository<User, String> {

    User findOneByEmailOrName(String tryEmail,
	    String tryUsername);

    User findOneByEmail(String mail);

}
