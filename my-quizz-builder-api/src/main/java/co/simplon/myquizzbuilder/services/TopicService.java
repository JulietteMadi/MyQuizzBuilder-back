package co.simplon.myquizzbuilder.services;

import java.util.Collection;

import co.simplon.myquizzbuilder.dtos.TopicDetailDto;
import co.simplon.myquizzbuilder.dtos.TopicCreateDto;
import co.simplon.myquizzbuilder.dtos.TopicForUpdateDto;

public interface TopicService {
    void createTopic(TopicCreateDto inputs);

    TopicDetailDto topicDetail(Long id);

    Collection<TopicForUpdateDto> getAll();

    public boolean nameValueExists(String name);
}
