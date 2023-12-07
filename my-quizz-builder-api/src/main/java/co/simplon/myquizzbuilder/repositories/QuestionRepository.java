package co.simplon.myquizzbuilder.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import co.simplon.myquizzbuilder.entities.Question;

public interface QuestionRepository
	extends JpaRepository<Question, String> {

}
