package fi.joufa.agilelogic.services;

import fi.joufa.agileservices.exceptions.AgileException;
import fi.joufa.domain.model.Team;
import fi.joufa.repositoryinterface.TeamRepository;
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
    return null;
  }

  @Override
  public Team editTeam(Team team) throws AgileException {
    return null;
  }

  @Override
  public Team deleteTeam(Long aLong) throws AgileException {
    return null;
  }

  @Override
  public Team findTeamById(Long aLong) throws AgileException {
    return null;
  }

  @Override
  public List<Team> findAll() {
    return null;
  }
}
