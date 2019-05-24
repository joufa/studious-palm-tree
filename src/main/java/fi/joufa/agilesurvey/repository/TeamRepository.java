package fi.joufa.agilesurvey.repository;

import fi.joufa.agilesurvey.domain.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {}
