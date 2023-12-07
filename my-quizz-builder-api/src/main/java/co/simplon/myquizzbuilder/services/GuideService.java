package co.simplon.myquizzbuilder.services;

import java.util.Collection;

import co.simplon.myquizzbuilder.dtos.topic.GuideItemDto;
import co.simplon.myquizzbuilder.dtos.topic.GuideVueDto;

public interface GuideService {

    void create(GuideItemDto inputs);

    void updateGuide(GuideItemDto inputs);

    Collection<GuideVueDto> getAll();

    public boolean urlValueExists(String url);

    public boolean nameValueExists(String name);

    public boolean nameValueExistsUpdate(String url,
	    Long id);
}
