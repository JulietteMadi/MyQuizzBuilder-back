package co.simplon.myquizzbuilder.dtos;

import java.util.List;

public interface TopicVueDto {
    Long getId();

    String getName();

    List<GuideVueDto> getGuides();
}
