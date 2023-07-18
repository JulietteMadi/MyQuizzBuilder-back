package co.simplon.myquizzbuilder.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.simplon.myquizzbuilder.dtos.GuideCreate;
import co.simplon.myquizzbuilder.dtos.TopicCreate;
import co.simplon.myquizzbuilder.entities.Guide;
import co.simplon.myquizzbuilder.entities.Topic;
import co.simplon.myquizzbuilder.repositories.GuideRepository;
import co.simplon.myquizzbuilder.repositories.TopicRepository;

@Service
@Transactional(readOnly = true)
public class TopicServiceImpl implements TopicService {

    private final TopicRepository topics;
    private final GuideRepository guides;

    public TopicServiceImpl(TopicRepository topics,
	    GuideRepository guides) {
	this.topics = topics;
	this.guides = guides;
    }

    @Transactional
    @Override
    public void createTopic(TopicCreate inputs) {
	Topic entity = new Topic();
	entity.setName(inputs.getName());
	ArrayList<Guide> guidesArray = new ArrayList<>();
	for (GuideCreate guide : inputs.getGuides()) {
	    Optional<Guide> guideOptional = guides
		    .findById(guide.getUrl());
	    if (guideOptional.isEmpty()) {
		createGuide(guide);
	    }
	    ;
	    Optional<Guide> allGuides = guides
		    .findById(guide.getUrl());
	    allGuides.ifPresent(guidesArray::add);
	}
	entity.setGuides(guidesArray);
	topics.save(entity);
    }

    public void createGuide(GuideCreate inputs) {
	Guide entity = new Guide();
	entity.setName(inputs.getName());
	entity.setUrl(inputs.getUrl());
	entity.setImage(inputs.getImage());
	guides.save(entity);
    }
}
