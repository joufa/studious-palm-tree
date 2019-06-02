package fi.joufa.databaserepository.repository;

import fi.joufa.databaserepository.model.TeamEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamEntityRepository extends JpaRepository<TeamEntity, Long> {}
