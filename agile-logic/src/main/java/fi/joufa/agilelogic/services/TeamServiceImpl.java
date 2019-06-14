package fi.joufa.agilelogic.services;

import fi.joufa.agileservices.exceptions.AgileException;
import fi.joufa.agileservices.services.TeamService;
import fi.joufa.domain.model.Team;
import fi.joufa.repositoryinterface.TeamRepositoryI;
import java.security.InvalidParameterException;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;

public class TeamServiceImpl implements TeamService {

  private final TeamRepositoryI teamRepository;

  @Inject
  public TeamServiceImpl(TeamRepositoryI teamRepository) {
    this.teamRepository = teamRepository;
  }

  @Override
  public Team createTeam(Team team) throws AgileException {
    try {
      final Team teamToCreate =
          new Team(
              null,
              team.getName(),
              team.getMemberCount(),
              team.getDescription(),
              LocalDateTime.now(),
              LocalDateTime.now());
      return teamRepository.createTeam(teamToCreate);
    } catch (Exception ex) {

      throw new AgileException("Team creation failed");
    }
  }

  @Override
  public Team editTeam(Team team) throws AgileException {
    try {
      final Team found = teamRepository.findTeamById(team.getTeamId());
      if (found == null) {
        throw new InvalidParameterException();
      }

      final String name = team.getName() != null ? team.getName() : found.getName();
      final Integer memberCount =
          team.getMemberCount() != null ? team.getMemberCount() : found.getMemberCount();
      final String desc =
          team.getDescription() != null ? team.getDescription() : found.getDescription();

      return teamRepository.updateTeam(
          new Team(
              team.getTeamId(), name, memberCount, desc, team.getCreatedAt(), LocalDateTime.now()));
    } catch (Exception ex) {
      throw new AgileException("Team update failed");
    }
  }

  @Override
  public Team deleteTeam(Long teamId) throws AgileException {
    if (teamId == null) {
      throw new AgileException("Team ID is empty");
    }
    final Team existingTeam = teamRepository.findTeamById(teamId);
    if (existingTeam == null) {
      throw new AgileException("Team not found");
    }
    return teamRepository.deleteTeam(existingTeam);
  }

  @Override
  public Optional<Team> findTeamById(Long teamId) {
    final Team team = teamRepository.findTeamById(teamId);
    return team != null ? Optional.of(team) : Optional.empty();
  }

  @Override
  public List<Team> findAll() {
    return !teamRepository.findAll().isEmpty() ? teamRepository.findAll() : Collections.emptyList();
  }
}
