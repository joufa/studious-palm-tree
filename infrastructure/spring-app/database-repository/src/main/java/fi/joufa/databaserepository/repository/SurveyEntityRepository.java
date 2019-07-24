package fi.joufa.databaserepository.repository;

import fi.joufa.databaserepository.model.SurveyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SurveyEntityRepository extends JpaRepository<SurveyEntity, Long> {}
