package co.simplon.myquizzbuilder.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import co.simplon.myquizzbuilder.entities.Topic;

public interface TopicRepository
	extends JpaRepository<Topic, String> {

}
