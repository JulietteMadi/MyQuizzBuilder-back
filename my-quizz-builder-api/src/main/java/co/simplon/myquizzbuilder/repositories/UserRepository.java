package co.simplon.myquizzbuilder.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import co.simplon.myquizzbuilder.entities.Manager;

public interface UserRepository
	extends JpaRepository<Manager, String> {

    Manager findOneByEmail(String mail);

    Manager findOneByName(String name);

    boolean existsByName(String string);

    boolean existsByEmail(String string);

}
