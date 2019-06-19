package fi.joufa.databaserepository.mapper;

import fi.joufa.databaserepository.config.DateFactory;
import fi.joufa.databaserepository.model.TeamEntity;
import fi.joufa.domain.model.StatusHistory;
import fi.joufa.domain.model.Team;
import fi.joufa.domain.model.TeamBuilder;
import fi.joufa.domain.model.common.TeamId;

public class DomainToEntityMapper {
  public TeamEntity teamToTeamEntity(Team team) {
    TeamEntity teamEntity = new TeamEntity();
    teamEntity.setId(team.getTeamId() != null ? team.getTeamId().getId() : null);
    teamEntity.setName(team.getName());
    teamEntity.setMemberCount(team.getMemberCount());
    teamEntity.setDescription(team.getDescription());
    teamEntity.setCreatedAt(DateFactory.convertToDate(team.getStatusHistory().getCreatedAt()));
    teamEntity.setUpdatedAt(DateFactory.convertToDate(team.getStatusHistory().getUpdatedAt()));
    return teamEntity;
  }

  public Team teamEntityToTeam(TeamEntity teamEntity) {
    return new TeamBuilder()
        .setTeamId(new TeamId(Long.valueOf(teamEntity.getId())))
        .setName(teamEntity.getName())
        .setMemberCount(teamEntity.getMemberCount())
        .setDescription(teamEntity.getDescription())
        .setStatusHistory(
            new StatusHistory(
                DateFactory.convertToLocalDateTime(teamEntity.getCreatedAt()),
                DateFactory.convertToLocalDateTime(teamEntity.getUpdatedAt())))
        .createTeam();
  }
}
