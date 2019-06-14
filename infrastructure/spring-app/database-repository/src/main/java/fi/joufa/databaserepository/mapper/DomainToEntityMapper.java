package fi.joufa.databaserepository.mapper;

import fi.joufa.databaserepository.config.DateFactory;
import fi.joufa.databaserepository.model.TeamEntity;
import fi.joufa.domain.model.Team;
import fi.joufa.domain.model.TeamBuilder;

public class DomainToEntityMapper {
  public TeamEntity teamToTeamEntity(Team team) {
    TeamEntity teamEntity = new TeamEntity();
    teamEntity.setId(team.getTeamId());
    teamEntity.setName(team.getName());
    teamEntity.setMemberCount(team.getMemberCount());
    teamEntity.setDescription(team.getDescription());
    teamEntity.setCreatedAt(DateFactory.convertToDate(team.getCreatedAt()));
    teamEntity.setUpdatedAt(DateFactory.convertToDate(team.getUpdatedAt()));
    return teamEntity;
  }

  public Team teamEntityToTeam(TeamEntity teamEntity) {
    return new TeamBuilder()
        .setName(teamEntity.getName())
        .setTeamId(teamEntity.getId())
        .setMemberCount(teamEntity.getMemberCount())
        .setDescription(teamEntity.getDescription())
        .setCreatedAt(DateFactory.convertToLocalDateTime(teamEntity.getCreatedAt()))
        .setUpdatedAt(DateFactory.convertToLocalDateTime(teamEntity.getUpdatedAt()))
        .createTeam();
  }
}
