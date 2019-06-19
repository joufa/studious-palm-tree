package fi.joufa.restservices.controller;

import fi.joufa.domain.model.Team;

public class DtoMapper {

  private DtoMapper() {
    throw new IllegalStateException("Utility class");
  }

  public static TeamRequestDto toDto(Team team) {
    final TeamRequestDto dto = new TeamRequestDto();
    dto.setTeamId(team.getTeamId().getId());
    dto.setName(team.getName());
    dto.setDescription(team.getDescription());
    dto.setMemberCount(team.getMemberCount());
    return dto;
  }
}
