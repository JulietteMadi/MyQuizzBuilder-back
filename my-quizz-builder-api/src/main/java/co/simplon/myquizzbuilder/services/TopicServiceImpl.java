package co.simplon.myquizzbuilder.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.simplon.myquizzbuilder.dtos.topic.GuideItemDto;
import co.simplon.myquizzbuilder.dtos.topic.TopicCreateDto;
import co.simplon.myquizzbuilder.dtos.topic.TopicForListDto;
import co.simplon.myquizzbuilder.dtos.topic.TopicUpdateDto;
import co.simplon.myquizzbuilder.dtos.topic.TopicVueDto;
import co.simplon.myquizzbuilder.dtos.topic.TopicsRequestedDto;
import co.simplon.myquizzbuilder.entities.Guide;
import co.simplon.myquizzbuilder.entities.Manager;
import co.simplon.myquizzbuilder.entities.Topic;
import co.simplon.myquizzbuilder.repositories.GuideRepository;
import co.simplon.myquizzbuilder.repositories.TopicRepository;
import co.simplon.myquizzbuilder.repositories.UserRepository;

@Service
@Transactional(readOnly = true)
public class TopicServiceImpl implements TopicService {

    private final TopicRepository topics;
    private final GuideService guideServices;
    private final GuideRepository guides;
    private final UserRepository users;

    public TopicServiceImpl(TopicRepository topics,
	    GuideRepository guides,
	    GuideService guideServices,
	    UserRepository users) {
	this.topics = topics;
	this.guides = guides;
	this.guideServices = guideServices;
	this.users = users;
    }

    @Override
    @Transactional
    public void createTopic(TopicCreateDto inputs,
	    Long userId) {
	Topic entity = new Topic();
	entity.setName(inputs.getName());
	Manager manager = users.getReferenceById(userId);
	entity.setManager(manager);
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
		guidesArray
			.add(guides.findById(guide.getId())
				.orElseThrow());
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
	System.out.println(topic.getName());
	return topic;
    }

    @Override
    public List<TopicVueDto> getRequestedTopics(
	    TopicsRequestedDto inputs) {
	List<TopicVueDto> topics = new ArrayList<TopicVueDto>();
	for (Long id : inputs.topicIds()) {
	    topics.add(this.topicVue(id));
	}
	return topics;
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
		guidesArray
			.add(guides.findById(guide.getId())
				.orElseThrow());
	    }
	}
	entity.setGuides(guidesArray);
	topics.save(entity);
    }

    @Override
    public List<Long> topicIdsByManager(Long managerId) {
	List<Long> quizIdsByManager = topics
		.findAllByManager(managerId);
	return quizIdsByManager;
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
