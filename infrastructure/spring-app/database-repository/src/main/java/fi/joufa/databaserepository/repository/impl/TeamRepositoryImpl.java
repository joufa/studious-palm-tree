package fi.joufa.databaserepository.repository.impl;

import fi.joufa.databaserepository.mapper.DomainToEntityMapper;
import fi.joufa.databaserepository.model.TeamEntity;
import fi.joufa.databaserepository.repository.TeamEntityRepository;
import fi.joufa.domain.model.Team;
import fi.joufa.repositoryinterface.TeamRepositoryI;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.inject.Inject;

public class TeamRepositoryImpl implements TeamRepositoryI {

  private static final Logger LOGGER = Logger.getLogger(TeamRepositoryImpl.class.getName());

  private final DomainToEntityMapper domainToEntityMapper;
  private final TeamEntityRepository teamEntityRepository;

  @Inject
  public TeamRepositoryImpl(
      DomainToEntityMapper domainToEntityMapper, TeamEntityRepository teamEntityRepository) {
    LOGGER.log(Level.FINER, "Initializing class..");
    this.domainToEntityMapper = domainToEntityMapper;
    this.teamEntityRepository = teamEntityRepository;
  }

  @Override
  public Team findTeamByName(String name) {
    final TeamEntity teamEntity = teamEntityRepository.findTeamEntityByName(name);
    if (teamEntity != null) {
      return domainToEntityMapper.teamEntityToTeam(teamEntity);
    }
    return null;
  }

  @Override
  public List<Team> findAll() {
    return teamEntityRepository.findAll().stream()
        .map(s -> domainToEntityMapper.teamEntityToTeam(s))
        .collect(Collectors.toList());
  }

  @Override
  public Team createTeam(Team team) {
    final TeamEntity teamEntity = domainToEntityMapper.teamToTeamEntity(team);
    return domainToEntityMapper.teamEntityToTeam(teamEntityRepository.save(teamEntity));
  }

  @Override
  public Team updateTeam(Team team) {
    LOGGER.log(Level.FINER, "updating team {0} ", team);
    final TeamEntity te = domainToEntityMapper.teamToTeamEntity(team);
    return domainToEntityMapper.teamEntityToTeam(teamEntityRepository.save(te));
  }

  @Override
  public Team deleteTeam(Team team) {
    teamEntityRepository.delete(domainToEntityMapper.teamToTeamEntity(team));
    return team;
  }
}
