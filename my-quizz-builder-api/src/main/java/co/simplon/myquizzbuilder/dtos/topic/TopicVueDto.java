package co.simplon.myquizzbuilder.dtos.topic;

import java.util.List;

public interface TopicVueDto {
    Long getId();

    String getName();

    List<GuideVueDto> getGuides();
}
