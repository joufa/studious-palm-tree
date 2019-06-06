package fi.joufa.agilelogic.services;

import fi.joufa.agileservices.exceptions.AgileException;
import fi.joufa.agileservices.services.TeamService;
import fi.joufa.domain.model.Team;
import fi.joufa.repositoryinterface.TeamRepositoryI;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;
import javax.transaction.Transactional;

public class TeamServiceImpl implements TeamService {

  private final TeamRepositoryI teamRepository;

  @Inject
  public TeamServiceImpl(TeamRepositoryI teamRepository) {
    this.teamRepository = teamRepository;
  }

  @Transactional
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

  @Transactional
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

  @Transactional
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
