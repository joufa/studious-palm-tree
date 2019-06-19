package fi.joufa.agilelogic.services;

import fi.joufa.agileservices.exceptions.AgileException;
import fi.joufa.agileservices.services.TeamService;
import fi.joufa.domain.model.StatusFactory;
import fi.joufa.domain.model.StatusHistoryTypes;
import fi.joufa.domain.model.Team;
import fi.joufa.domain.model.TeamBuilder;
import fi.joufa.repositoryinterface.TeamRepositoryI;
import java.security.InvalidParameterException;
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
      if (team.getName() == null) {
        throw new IllegalArgumentException();
      }
      return teamRepository.createTeam(
          new TeamBuilder()
              .setName(team.getName())
              .setDescription(team.getDescription())
              .setMemberCount(team.getMemberCount())
              .setStatusHistory(StatusFactory.create(StatusHistoryTypes.BOTH))
              .createTeam());
    } catch (Exception ex) {
      throw new AgileException("Team creation failed");
    }
  }

  @Override
  public Team editTeam(Team team) throws AgileException {
    try {
      final Team found = teamRepository.findTeamByName(team.getName());
      if (found == null) {
        throw new InvalidParameterException();
      }

      final Integer memberCount =
          team.getMemberCount() != null ? team.getMemberCount() : found.getMemberCount();
      final String desc =
          team.getDescription() != null ? team.getDescription() : found.getDescription();

      final Team teamToUpdate =
          new TeamBuilder()
              .setTeamId(team.getTeamId())
              .setName(team.getName())
              .setMemberCount(memberCount)
              .setDescription(desc)
              .setStatusHistory(StatusFactory.update(team.getStatusHistory()))
              .createTeam();
      return teamRepository.updateTeam(teamToUpdate);
    } catch (Exception ex) {
      throw new AgileException("Team update failed: " + ex.getMessage());
    }
  }

  @Override
  public Team deleteTeam(Team team) throws AgileException {

    final Team found = teamRepository.findTeamByName(team.getName());

    if (found == null) {
      throw new AgileException("Team not found");
    }

    return teamRepository.deleteTeam(found);
  }

  @Override
  public Optional<Team> findTeamByName(String team) {
    final Team found = teamRepository.findTeamByName(team);
    if (found != null) {
      return Optional.of(found);
    }
    return Optional.empty();
  }

  @Override
  public List<Team> findAll() {
    return !teamRepository.findAll().isEmpty() ? teamRepository.findAll() : Collections.emptyList();
  }
}
