package fi.joufa.restservices.controller;

import fi.joufa.agileservices.exceptions.AgileException;
import fi.joufa.agileservices.services.TeamService;
import fi.joufa.domain.model.Team;
import fi.joufa.domain.model.TeamBuilder;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api")
public class TeamController {

  private final TeamService teamService;

  @Autowired
  public TeamController(TeamService teamService) {
    this.teamService = teamService;
  }

  @GetMapping(path = "/teams")
  public List<Team> findAll() {
    return teamService.findAll();
  }

  @GetMapping(path = "/teams/{id}")
  public Team findOne(@PathVariable("id") Long id) throws AgileException {
    final Optional<Team> team = teamService.findTeamById(id);
    if (team.isPresent()) {
      return team.get();
    } else {
      throw new AgileException("Team not found");
    }
  }

  @PostMapping(path = "/teams")
  public Team createTeam(@RequestBody TeamRequestDto teamRequestDto) throws AgileException {
    return teamService.createTeam(
        new TeamBuilder()
            .setName(teamRequestDto.getName())
            .setMemberCount(teamRequestDto.getMemberCount())
            .setDescription(teamRequestDto.getDescription())
            .createTeam());
  }

  @PutMapping(path = "/teams")
  public Team updateTeam(@RequestBody TeamRequestDto teamRequestDto) throws AgileException {
    return teamService.editTeam(
        new TeamBuilder()
            .setTeamId(teamRequestDto.getTeamId())
            .setName(teamRequestDto.getName())
            .setMemberCount(teamRequestDto.getMemberCount())
            .setDescription(teamRequestDto.getDescription())
            .createTeam());
  }

  @DeleteMapping(path = "/teams/{id}")
  public Team deleteTeam(@PathVariable("id") Long id) throws AgileException {
    return teamService.deleteTeam(id);
  }
}
