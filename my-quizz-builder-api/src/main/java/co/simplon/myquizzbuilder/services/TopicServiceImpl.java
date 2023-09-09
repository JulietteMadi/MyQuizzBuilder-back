package co.simplon.myquizzbuilder.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.simplon.myquizzbuilder.controllers.GuideController;
import co.simplon.myquizzbuilder.dtos.GuideCreateDto;
import co.simplon.myquizzbuilder.dtos.TopicDetailDto;
import co.simplon.myquizzbuilder.dtos.TopicCreateDto;
import co.simplon.myquizzbuilder.dtos.TopicForUpdateDto;
import co.simplon.myquizzbuilder.entities.Guide;
import co.simplon.myquizzbuilder.entities.Topic;
import co.simplon.myquizzbuilder.repositories.GuideRepository;
import co.simplon.myquizzbuilder.repositories.TopicRepository;

@Service
@Transactional(readOnly = true)
public class TopicServiceImpl implements TopicService {

    private final TopicRepository topics;
    private final GuideService guideServices;
    private final GuideController guideController;
    private final GuideRepository guides; // Need guide repo. to check if a topics guide already exists at createTopic()

    public TopicServiceImpl(TopicRepository topics,
	    GuideRepository guides,
	    GuideController guideController,
	    GuideService guideServices) {
	this.topics = topics;
	this.guides = guides;
	this.guideController = guideController;
	this.guideServices = guideServices;
    }

    @Transactional
    @Override
    public void createTopic(TopicCreateDto inputs) {
	Topic entity = new Topic();
	entity.setName(inputs.getName());
	List<Guide> guidesArray = new ArrayList<>();
	for (GuideCreateDto guide : inputs.getGuides()) {
	    Optional<Guide> guideOptional = guides
		    .findById(guide.getUrl());
	    if (guideOptional.isEmpty()) {
		guideController.create(guide);
	    }
	    ;
	    Optional<Guide> allGuides = guides
		    .findById(guide.getUrl());
	    allGuides.ifPresent(guidesArray::add);
	}
	entity.setGuides(guidesArray);
	topics.save(entity);
    }

    @Override
    public TopicDetailDto topicDetail(Long id) {
	Topic entity = topics.findById(id).orElse(null);
	if (entity == null) {
	    return null;
	}
	TopicDetailDto inputs = new TopicDetailDto();
	inputs.setId(entity.getId());
	inputs.setName(entity.getName());
	List<GuideCreateDto> guideDtos = entity.getGuides()
		.stream().map(guideServices::convertToDto)
		.collect(Collectors.toList());
	inputs.setGuides(guideDtos);
	return inputs;
    };

    @Override
    public Collection<TopicForUpdateDto> getAll() {
	return topics.findAllProjectedBy();
    };

    @Override
    public boolean nameValueExists(String name)
	    throws UnsupportedOperationException {
	return this.topics.existsByName(name.toString());
    }
}
