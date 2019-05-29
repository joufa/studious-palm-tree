package fi.joufa.agilesurvey;

import fi.joufa.agilesurvey.domain.Team;
import fi.joufa.agilesurvey.repository.TeamRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TeamController extends BaseController {

  @Autowired private TeamRepository teamRepository;

  @GetMapping(value = "/teams")
  public List<Team> findTeams() {
    return teamRepository.findAll();
  }

  @GetMapping(value = "/teams/{id}")
  public Team findTeam(@PathVariable("id") Long id) {
    Optional<Team> team = teamRepository.findById(id);
    return team.isPresent() ? team.get() : null;
  }

  @PostMapping(value = "/teams")
  public Team createTeam(@RequestBody Team team) {
    return teamRepository.save(team);
  }
}
