package co.simplon.myquizzbuilder.services;

import java.util.Collection;

import co.simplon.myquizzbuilder.dtos.GuideItemDto;
import co.simplon.myquizzbuilder.dtos.GuideVueDto;

public interface GuideService {

    void create(GuideItemDto inputs);

    void updateGuide(GuideItemDto inputs);

    Collection<GuideVueDto> getAll();

    public boolean urlValueExists(String url);

    public boolean nameValueExists(String name);
}
