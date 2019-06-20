package fi.joufa.restservices.controller;

import fi.joufa.domain.model.Team;
import java.time.ZoneId;
import java.util.Date;

public class DtoMapper {

  public TeamRequestDto toDto(Team team) {
    final TeamRequestDto dto = new TeamRequestDto();
    dto.setTeamId(team.getTeamId().getId());
    dto.setName(team.getName());
    dto.setDescription(team.getDescription());
    dto.setMemberCount(team.getMemberCount());
    dto.setCreatedAt(
        team.getStatusHistory() != null
            ? Date.from(
                team.getStatusHistory().getCreatedAt().atZone(ZoneId.systemDefault()).toInstant())
            : null);
    dto.setUpdatedAt(
        team.getStatusHistory() != null
            ? Date.from(
                team.getStatusHistory().getUpdatedAt().atZone(ZoneId.systemDefault()).toInstant())
            : null);
    return dto;
  }
}
