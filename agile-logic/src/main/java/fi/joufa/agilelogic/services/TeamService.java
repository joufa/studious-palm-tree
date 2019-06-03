package fi.joufa.agilelogic.services;

import fi.joufa.agileservices.exceptions.AgileException;
import fi.joufa.domain.model.Team;
import fi.joufa.repositoryinterface.TeamRepository;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;

public class TeamService implements fi.joufa.agileservices.services.TeamService {

  private final TeamRepository teamRepository;

  @Inject
  public TeamService(TeamRepository teamRepository) {
    this.teamRepository = teamRepository;
  }

  @Override
  public Team createTeam(Team team) throws AgileException {
    if (team.getName() == null) {
      throw new AgileException("Team name cannot be empty");
    }
    final Team existingTeam = teamRepository.findTeamByName(team.getName());
    if (team.getName().equals(existingTeam.getName())) {
      throw new AgileException("Team name must be unique");
    }

    return teamRepository.createTeam(team);
  }

  @Override
  public Team editTeam(Team team) throws AgileException {
    if (team.getTeamId() == null) {
      throw new AgileException("Team ID is empty");
    }
    if (team.getName() == null) {
      throw new AgileException("Team name cannot be empty");
    }
    return teamRepository.updateTeam(
        new Team(team.getTeamId(), team.getName(), team.getMemberCount(), team.getDescription()));
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
  public Team findTeamById(Long teamId) throws AgileException {
    final Team team = teamRepository.findTeamById(teamId);
    if (team == null) {
      throw new AgileException("No team found");
    }
    return team;
  }

  @Override
  public List<Team> findAll() {
    return !teamRepository.findAll().isEmpty() ? teamRepository.findAll() : Collections.emptyList();
  }
}
