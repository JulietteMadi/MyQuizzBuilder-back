package co.simplon.myquizzbuilder.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import co.simplon.myquizzbuilder.entities.User;

public interface UserRepository
	extends JpaRepository<User, String> {

    User findOneByEmail(String mail);

    User findOneByName(String name);

    boolean existsByName(String string);

    boolean existsByEmail(String string);

}
