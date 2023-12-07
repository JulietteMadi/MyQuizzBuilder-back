package co.simplon.myquizzbuilder.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import co.simplon.myquizzbuilder.entities.AvailableAnswer;

public interface AvailableAnswerRepository
	extends JpaRepository<AvailableAnswer, String> {

}
