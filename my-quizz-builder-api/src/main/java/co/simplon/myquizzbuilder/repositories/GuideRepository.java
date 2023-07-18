package co.simplon.myquizzbuilder.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import co.simplon.myquizzbuilder.entities.Guide;

public interface GuideRepository
	extends JpaRepository<Guide, String> {

    @Override
    Guide getById(String guideId);

}
