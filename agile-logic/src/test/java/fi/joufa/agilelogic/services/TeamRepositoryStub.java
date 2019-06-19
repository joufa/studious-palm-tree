package fi.joufa.agilelogic.services;

import fi.joufa.domain.model.StatusFactory;
import fi.joufa.domain.model.Team;
import fi.joufa.domain.model.TeamBuilder;
import fi.joufa.domain.model.common.TeamId;
import fi.joufa.repositoryinterface.TeamRepositoryI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TeamRepositoryStub implements TeamRepositoryI {

  private final List<Team> teams;
  private Integer sequence = 1;

  public TeamRepositoryStub(Team... teams) {
    this.teams = new ArrayList();
    this.teams.addAll(Arrays.asList(teams));
  }

  public static Team addTeam() {
    return new Team(
        new TeamId(Long.valueOf(1)), "Testi", 3, "Testitiimi", StatusFactory.createHistory());
  }

  @Override
  public List<Team> findAll() {
    return teams;
  }

  @Override
  public Team createTeam(Team team) {
    final Team teamToAdd =
        new TeamBuilder()
            .setTeamId(new TeamId(Long.valueOf(sequence + 1)))
            .setName(team.getName())
            .setMemberCount(team.getMemberCount())
            .setDescription(team.getDescription())
            .createTeam();
    if (!this.teams.contains(teamToAdd)) {
      this.teams.add(teamToAdd);
    } else {
      return null;
    }
    return teamToAdd;
  }

  @Override
  public Team updateTeam(Team team) {
    List<Team> tmp =
        teams.stream().filter(teamInList -> !teamInList.equals(team)).collect(Collectors.toList());
    teams.clear();
    teams.addAll(tmp);
    teams.add(team);
    return team;
  }

  @Override
  public Team deleteTeam(Team team) {
    List<Team> tmp =
        teams.stream().filter(teamInList -> !teamInList.equals(team)).collect(Collectors.toList());
    teams.clear();
    teams.addAll(tmp);
    return team;
  }

  @Override
  public Team findTeamByName(String name) {
    return teams.stream().filter(team -> team.getName().equals(name)).findFirst().orElse(null);
  }
}
