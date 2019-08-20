package fi.joufa.restservices.controller;

import fi.joufa.domain.model.Survey;
import fi.joufa.domain.model.SurveyBuilder;
import fi.joufa.domain.model.SurveyUpdate;
import fi.joufa.domain.model.Team;
import fi.joufa.domain.model.common.SurveyId;
import fi.joufa.domain.model.common.TeamId;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

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

  public SurveyDto toDto(Survey survey) {
    final SurveyDto dto = new SurveyDto();
    dto.setId(survey.getSurveyId().get());
    dto.setName(survey.getName());
    dto.setCreatedAt(
        survey.getStatusHistory() != null
            ? Date.from(
                survey.getStatusHistory().getCreatedAt().atZone(ZoneId.systemDefault()).toInstant())
            : null);
    dto.setUpdatedAt(
        survey.getStatusHistory() != null
            ? Date.from(
                survey.getStatusHistory().getUpdatedAt().atZone(ZoneId.systemDefault()).toInstant())
            : null);

    Set<Long> teams = new HashSet<>();

    if (survey.getTeams() != null || !survey.getTeams().isEmpty()) {
      teams = survey.getTeams().stream().map(id -> id.getId()).collect(Collectors.toSet());
    }

    dto.setTeams(teams);

    return dto;
  }

  public Survey toSurvey(SurveyDto dto) {
    return new SurveyBuilder()
        .setSurveyId(dto.getId())
        .setName(dto.getName())
        .setAllTeams(dto.getTeams().stream().map(id -> new TeamId(id)).collect(Collectors.toSet()))
        .createSurvey();
  }

  public SurveyUpdate toUpdate(SurveyDto surveyDto) {
    final SurveyUpdate update = new SurveyUpdate(new SurveyId(Long.valueOf(surveyDto.getId())));
    if (surveyDto.getTeams() != null) {
      update.setTeams(
          surveyDto.getTeams().stream().map(team -> new TeamId(team)).collect(Collectors.toSet()));
    }
    return update;
  }
}
