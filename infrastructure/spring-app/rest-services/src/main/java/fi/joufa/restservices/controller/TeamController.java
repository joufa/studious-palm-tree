package fi.joufa.restservices.controller;

import fi.joufa.agileservices.exceptions.AgileException;
import fi.joufa.agileservices.services.TeamService;
import fi.joufa.domain.model.Team;
import fi.joufa.domain.model.TeamBuilder;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping(path = "/api")
public class TeamController {

  private final TeamService teamService;
  private DtoMapper dtoMapper = new DtoMapper();

  public TeamController(TeamService teamService) {
    this.teamService = teamService;
  }

  @GetMapping(path = "/teams")
  public List<TeamRequestDto> findAll() {
    return teamService.findAll().stream()
        .map(team -> dtoMapper.toDto(team))
        .collect(Collectors.toList());
  }

  @PostMapping(path = "/teams")
  public TeamRequestDto createTeam(@RequestBody TeamRequestDto teamRequestDto) {
    try {
      return dtoMapper.toDto(
          teamService.createTeam(
              new TeamBuilder()
                  .setName(teamRequestDto.getName())
                  .setMemberCount(teamRequestDto.getMemberCount())
                  .setDescription(teamRequestDto.getDescription())
                  .createTeam()));
    } catch (AgileException ex) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage(), ex);
    }
  }

  @PutMapping(path = "/teams")
  public TeamRequestDto updateTeam(@RequestBody TeamRequestDto teamRequestDto)
      throws AgileException {
    return dtoMapper.toDto(
        teamService.editTeam(
            new TeamBuilder()
                .setName(teamRequestDto.getName())
                .setMemberCount(teamRequestDto.getMemberCount())
                .setDescription(teamRequestDto.getDescription())
                .createTeam()));
  }

  // TODO
  @DeleteMapping(path = "/teams/{id}")
  public Team deleteTeam(@PathVariable("id") Long id) throws AgileException {
    return null;
  }
}
