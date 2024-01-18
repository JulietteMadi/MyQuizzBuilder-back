package co.simplon.myquizzbuilder.repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import co.simplon.myquizzbuilder.dtos.topic.TopicForListDto;
import co.simplon.myquizzbuilder.dtos.topic.TopicVueDto;
import co.simplon.myquizzbuilder.entities.Topic;

public interface TopicRepository
	extends JpaRepository<Topic, Long> {

    TopicVueDto findProjectedDetailById(Long id);

    Collection<TopicForListDto> findAllProjectedBy();

    boolean existsByName(String string);

    boolean existsByNameAndIdIsNot(String name, Long id);

    Topic getReferenceById(Integer topicId);

}
