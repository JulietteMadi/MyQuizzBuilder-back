package co.simplon.myquizzbuilder.services;

import java.util.Collection;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.simplon.myquizzbuilder.dtos.GuideCreateDto;
import co.simplon.myquizzbuilder.dtos.GuideVueDto;
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
    public GuideCreateDto convertToDto(Guide entity) {
	GuideCreateDto inputs = new GuideCreateDto();
	inputs.setUrl(entity.getUrl());
	inputs.setName(entity.getName());
	inputs.setImage(entity.getImage());
	return inputs;
    }

    @Override
    public void createGuide(GuideCreateDto inputs) {
	Guide entity = new Guide();
	entity.setName(inputs.getName());
	entity.setUrl(inputs.getUrl());
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

}
