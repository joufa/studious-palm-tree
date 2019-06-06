package fi.joufa.databaserepository.repository.impl;

import fi.joufa.databaserepository.mapper.DomainToEntityMapper;
import fi.joufa.databaserepository.model.TeamEntity;
import fi.joufa.databaserepository.repository.TeamEntityRepository;
import fi.joufa.domain.model.Team;
import fi.joufa.repositoryinterface.TeamRepositoryI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;

/** @author udanre */
public class TeamRepositoryImpl implements TeamRepositoryI {

  private final DomainToEntityMapper domainToEntityMapper;
  private final TeamEntityRepository teamEntityRepository;

  @Inject
  public TeamRepositoryImpl(
      DomainToEntityMapper domainToEntityMapper, TeamEntityRepository teamEntityRepository) {
    this.domainToEntityMapper = domainToEntityMapper;
    this.teamEntityRepository = teamEntityRepository;
  }

  @Override
  public Team findTeamById(Long teamId) {
    Optional<TeamEntity> teamEntity = teamEntityRepository.findById(teamId);
    if (teamEntity.isPresent()) {
      return domainToEntityMapper.teamEntityToTeam(teamEntity.get());
    }
    return null;
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
    final List<TeamEntity> entities = teamEntityRepository.findAll();
    return entities.stream()
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
    final TeamEntity teamToUpdate = teamEntityRepository.getOne(team.getTeamId());
    teamToUpdate.setName(team.getName());
    teamToUpdate.setMemberCount(team.getMemberCount());
    teamToUpdate.setDescription(team.getDescription());
    return domainToEntityMapper.teamEntityToTeam(teamEntityRepository.save(teamToUpdate));
  }

  @Override
  public Team deleteTeam(Team team) {
    teamEntityRepository.delete(domainToEntityMapper.teamToTeamEntity(team));
    return team;
  }
}
