package co.simplon.myquizzbuilder.repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import co.simplon.myquizzbuilder.dtos.GuideVueDto;
import co.simplon.myquizzbuilder.entities.Guide;

public interface GuideRepository
	extends JpaRepository<Guide, String> {

    @Override
    Guide getById(String guideId);

    Collection<GuideVueDto> findAllProjectedBy();

    boolean existsByUrl(String string);

    boolean existsByName(String string);

}
