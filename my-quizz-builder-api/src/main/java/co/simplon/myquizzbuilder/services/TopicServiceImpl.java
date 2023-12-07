package co.simplon.myquizzbuilder.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.simplon.myquizzbuilder.dtos.topic.GuideItemDto;
import co.simplon.myquizzbuilder.dtos.topic.TopicCreateDto;
import co.simplon.myquizzbuilder.dtos.topic.TopicForListDto;
import co.simplon.myquizzbuilder.dtos.topic.TopicUpdateDto;
import co.simplon.myquizzbuilder.dtos.topic.TopicVueDto;
import co.simplon.myquizzbuilder.entities.Guide;
import co.simplon.myquizzbuilder.entities.Topic;
import co.simplon.myquizzbuilder.repositories.GuideRepository;
import co.simplon.myquizzbuilder.repositories.TopicRepository;

@Service
@Transactional(readOnly = true)
public class TopicServiceImpl implements TopicService {

    private final TopicRepository topics;
    private final GuideService guideServices;
    private final GuideRepository guides;

    public TopicServiceImpl(TopicRepository topics,
	    GuideRepository guides,
	    GuideService guideServices) {
	this.topics = topics;
	this.guides = guides;
	this.guideServices = guideServices;
    }

    @Override
    @Transactional
    public void createTopic(TopicCreateDto inputs) {
	Topic entity = new Topic();
	entity.setName(inputs.getName());
	List<@Valid Guide> guidesArray = new ArrayList<>();
	for (GuideItemDto guide : inputs.getGuides()) {
	    if (guide.getId() == null) {
		guideServices.create(guide);
		guidesArray.add(
			guides.findByUrl(guide.getUrl()));
	    } else {
		if (guide.getName() != null) {
		    guideServices.updateGuide(guide);
		}
		guidesArray.add(
			guides.findById(guide.getId()));
	    }
	}
	entity.setGuides(guidesArray);
	topics.save(entity);
    }

    @Override
    public Collection<TopicForListDto> getAll() {
	return topics.findAllProjectedBy();
    };

    @Override
    public TopicVueDto topicVue(Long id) {
	TopicVueDto topic = topics
		.findProjectedDetailById(id);
	topic.getGuides().size();
	return topic;
    }

    @Override
    @Transactional
    public void updateTopic(Long id,
	    TopicUpdateDto inputs) {
	Topic entity = topics.findById(id).get();
	entity.setName(inputs.getName());
	List<Guide> guidesArray = new ArrayList<>();
	for (GuideItemDto guide : inputs.getGuides()) {
	    if (guide.getId() == null) {
		guideServices.create(guide);
		guidesArray.add(
			guides.findByUrl(guide.getUrl()));
	    } else {
		if (guide.getName() != null) {
		    guideServices.updateGuide(guide);
		}
		guidesArray.add(
			guides.findById(guide.getId()));
	    }
	}
	entity.setGuides(guidesArray);
	topics.save(entity);
    }

    @Override
    @Transactional
    public void delete(Long id) {
	topics.deleteById(id);
    }

    @Override
    public boolean nameValueExists(String name)
	    throws UnsupportedOperationException {
	return this.topics.existsByName(name.toString());
    }

    @Override
    public boolean nameValueExistsUpdate(String name,
	    Long id) throws UnsupportedOperationException {
	return topics.existsByNameAndIdIsNot(name, id);
    }
}
