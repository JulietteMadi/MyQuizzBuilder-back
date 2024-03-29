package co.simplon.myquizzbuilder.services;

import java.util.Collection;
import java.util.List;

import co.simplon.myquizzbuilder.dtos.topic.TopicCreateDto;
import co.simplon.myquizzbuilder.dtos.topic.TopicForListDto;
import co.simplon.myquizzbuilder.dtos.topic.TopicUpdateDto;
import co.simplon.myquizzbuilder.dtos.topic.TopicVueDto;
import co.simplon.myquizzbuilder.dtos.topic.TopicsRequestedDto;

public interface TopicService {
    void createTopic(TopicCreateDto inputs, Long userId);

    void updateTopic(Long id, TopicUpdateDto inputs);

    Collection<TopicForListDto> getAll();

    public boolean nameValueExists(String name);

    public boolean nameValueExistsUpdate(String name,
	    Long id);

    public List<Long> topicIdsByManager(Long managerId);

    void delete(Long id);

    TopicVueDto topicVue(Long id);

    public List<TopicVueDto> getRequestedTopics(
	    TopicsRequestedDto inputs);
}
