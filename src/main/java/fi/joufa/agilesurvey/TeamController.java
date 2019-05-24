package fi.joufa.agilesurvey;

import fi.joufa.agilesurvey.domain.Team;
import fi.joufa.agilesurvey.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TeamController {

  @Autowired private TeamRepository teamRepository;

  @GetMapping(value = "/teams")
  public List<Team> findTeams() {
    return teamRepository.findAll();
  }
}
