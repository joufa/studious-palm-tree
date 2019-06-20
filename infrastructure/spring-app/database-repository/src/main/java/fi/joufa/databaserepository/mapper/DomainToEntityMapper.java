package fi.joufa.databaserepository.mapper;

import fi.joufa.databaserepository.config.DateFactory;
import fi.joufa.databaserepository.model.TeamEntity;
import fi.joufa.domain.model.StatusHistory;
import fi.joufa.domain.model.Team;
import fi.joufa.domain.model.TeamBuilder;
import fi.joufa.domain.model.common.TeamId;
import javax.inject.Inject;

public class DomainToEntityMapper {

  private DateFactory dateFactory;

  @Inject
  public DomainToEntityMapper(DateFactory dateFactory) {
    this.dateFactory = dateFactory;
  }

  public TeamEntity teamToTeamEntity(Team team) {
    TeamEntity teamEntity = new TeamEntity();
    teamEntity.setId(team.getTeamId() != null ? team.getTeamId().getId() : null);
    teamEntity.setName(team.getName());
    teamEntity.setMemberCount(team.getMemberCount());
    teamEntity.setDescription(team.getDescription());
    teamEntity.setCreatedAt(dateFactory.convertToDate(team.getStatusHistory().getCreatedAt()));
    teamEntity.setUpdatedAt(dateFactory.convertToDate(team.getStatusHistory().getUpdatedAt()));
    return teamEntity;
  }

  public Team teamEntityToTeam(TeamEntity teamEntity) {
    return new TeamBuilder()
        .setTeamId(new TeamId(teamEntity.getId()))
        .setName(teamEntity.getName())
        .setMemberCount(teamEntity.getMemberCount())
        .setDescription(teamEntity.getDescription())
        .setStatusHistory(
            new StatusHistory(
                dateFactory.convertToLocalDateTime(teamEntity.getCreatedAt()),
                dateFactory.convertToLocalDateTime(teamEntity.getUpdatedAt())))
        .createTeam();
  }
}
