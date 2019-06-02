package fi.joufa.agilesurvey.repository;

import fi.joufa.agilesurvey.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {}
