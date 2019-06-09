package fi.joufa.databaserepository.mapper;

import fi.joufa.databaserepository.model.TeamEntity;
import fi.joufa.domain.model.Team;
import fi.joufa.domain.model.TeamBuilder;

/** @author udanre */
public class DomainToEntityMapper {
  public TeamEntity teamToTeamEntity(Team team) {
    TeamEntity teamEntity = new TeamEntity();
    teamEntity.setId(team.getTeamId());
    teamEntity.setName(team.getName());
    teamEntity.setMemberCount(team.getMemberCount());
    teamEntity.setDescription(team.getDescription());
    return teamEntity;
  }

  public Team teamEntityToTeam(TeamEntity teamEntity) {
    return new TeamBuilder()
        .setName(teamEntity.getName())
        .setTeamId(teamEntity.getId())
        .setMemberCount(teamEntity.getMemberCount())
        .setDescription(teamEntity.getDescription())
        .createTeam();
  }
}
