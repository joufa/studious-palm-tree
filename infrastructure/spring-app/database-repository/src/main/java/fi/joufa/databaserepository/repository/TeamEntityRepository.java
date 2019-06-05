package fi.joufa.databaserepository.repository;

import fi.joufa.databaserepository.model.TeamEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamEntityRepository extends JpaRepository<TeamEntity, Long> {
  TeamEntity findTeamEntityByName(String name);
}
