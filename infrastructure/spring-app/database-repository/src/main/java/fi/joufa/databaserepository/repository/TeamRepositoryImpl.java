/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.joufa.databaserepository.repository;

import fi.joufa.databaserepository.mapper.DomainToEntityMapper;
import fi.joufa.databaserepository.model.TeamEntity;
import fi.joufa.domain.model.Team;
import fi.joufa.repositoryinterface.TeamRepository;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;

/** @author udanre */
public class TeamRepositoryImpl implements TeamRepository {

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
    if (teamEntity.get() != null) {
      return domainToEntityMapper.teamEntityToTeam(teamEntity.get());
    }
    return null;
  }

  @Override
  public Team findTeamByName(String name) {
    throw new UnsupportedOperationException(
        "Not supported yet."); // To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public List<Team> findAll() {
    throw new UnsupportedOperationException(
        "Not supported yet."); // To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public Team createTeam(Team team) {
    throw new UnsupportedOperationException(
        "Not supported yet."); // To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public Team updateTeam(Team team) {
    throw new UnsupportedOperationException(
        "Not supported yet."); // To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public Team deleteTeam(Team team) {
    throw new UnsupportedOperationException(
        "Not supported yet."); // To change body of generated methods, choose Tools | Templates.
  }
}
