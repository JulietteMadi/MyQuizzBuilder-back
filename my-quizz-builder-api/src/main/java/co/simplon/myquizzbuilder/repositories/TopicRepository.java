package co.simplon.myquizzbuilder.repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import co.simplon.myquizzbuilder.dtos.TopicCreateDto;
import co.simplon.myquizzbuilder.dtos.TopicForUpdateDto;
import co.simplon.myquizzbuilder.entities.Topic;

public interface TopicRepository
	extends JpaRepository<Topic, Long> {

    TopicCreateDto findProjectedDetailById(Long id);

    Collection<TopicForUpdateDto> findAllProjectedBy();

    boolean existsByName(String string);

}
