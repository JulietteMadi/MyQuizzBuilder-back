package co.simplon.myquizzbuilder.services;

import java.util.Collection;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.simplon.myquizzbuilder.dtos.topic.GuideItemDto;
import co.simplon.myquizzbuilder.dtos.topic.GuideVueDto;
import co.simplon.myquizzbuilder.entities.Guide;
import co.simplon.myquizzbuilder.repositories.GuideRepository;

@Service
@Transactional(readOnly = true)
public class GuideServiceImpl implements GuideService {

    private final GuideRepository guides;

    public GuideServiceImpl(GuideRepository guides) {
	this.guides = guides;
    }

    @Override
    @Transactional
    public void create(GuideItemDto inputs) {
	Guide entity = new Guide();
	entity.setName(inputs.getName());
	entity.setUrl(inputs.getUrl());
	entity.setImage(inputs.getImage());
	guides.save(entity);
    }

    @Override
    @Transactional
    public void updateGuide(GuideItemDto inputs) {
	Guide entity = guides.findById(inputs.getId());
	entity.setName(inputs.getName());
	entity.setImage(inputs.getImage());
	guides.save(entity);
    }

    @Override
    public Collection<GuideVueDto> getAll() {
	return guides.findAllProjectedBy();
    }

    @Override
    public boolean urlValueExists(String url)
	    throws UnsupportedOperationException {
	return this.guides.existsByUrl(url.toString());
    }

    @Override
    public boolean nameValueExists(String name)
	    throws UnsupportedOperationException {
	return this.guides.existsByName(name.toString());
    }

    @Override
    public boolean nameValueExistsUpdate(String name,
	    Long id) throws UnsupportedOperationException {
	return guides.existsByNameAndIdIsNot(name, id);
    }

}
