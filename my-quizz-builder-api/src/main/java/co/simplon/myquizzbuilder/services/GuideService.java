package co.simplon.myquizzbuilder.services;

import java.util.Collection;

import co.simplon.myquizzbuilder.dtos.GuideCreateDto;
import co.simplon.myquizzbuilder.dtos.GuideVueDto;
import co.simplon.myquizzbuilder.entities.Guide;

public interface GuideService {
    GuideCreateDto convertToDto(Guide entity);

    void createGuide(GuideCreateDto inputs);

    Collection<GuideVueDto> getAll();

    public boolean urlValueExists(String url);

    public boolean nameValueExists(String name);
}
