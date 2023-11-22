package co.simplon.myquizzbuilder.services;

import java.util.Collection;

import co.simplon.myquizzbuilder.dtos.TopicCreateDto;
import co.simplon.myquizzbuilder.dtos.TopicForListDto;
import co.simplon.myquizzbuilder.dtos.TopicUpdateDto;
import co.simplon.myquizzbuilder.dtos.TopicVueDto;

public interface TopicService {
    void createTopic(TopicCreateDto inputs);

    void updateTopic(Long id, TopicUpdateDto inputs);

    Collection<TopicForListDto> getAll();

    public boolean nameValueExists(String name);

    public boolean nameValueExistsUpdate(String name,
	    Long id);

    void delete(Long id);

    TopicVueDto topicVue(Long id);
}
