package fi.joufa.agilelogic.services;

import fi.joufa.domain.model.Team;
import fi.joufa.repositoryinterface.TeamRepository;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TeamRepositoryStub implements TeamRepository {

  private final List<Team> teams;

  public TeamRepositoryStub(Team... teams) {
    this.teams = new ArrayList();
    this.teams.addAll(Arrays.asList(teams));
  }

  public static Team addTeam() {
    return new Team(Long.valueOf(1), "Testi", 3, "Testitiimi");
  }

  @Override
  public Team findTeamById(Long id) {
    return teams.stream().filter(team -> team.getTeamId().equals(id)).findFirst().orElse(null);
  }

  @Override
  public List<Team> findAll() {
    return teams;
  }

  @Override
  public Team createTeam(Team team) {
    teams.add(team);
    return team;
  }

  @Override
  public Team updateTeam(Team team) {
    List<Team> tmp =
        teams.stream()
            .filter(teamInList -> !teamInList.getTeamId().equals(team.getTeamId()))
            .collect(Collectors.toList());
    teams.clear();
    teams.addAll(tmp);
    teams.add(team);
    return team;
  }

  @Override
  public Team deleteTeam(Team team) {
    List<Team> tmp =
        teams.stream()
            .filter(teamInList -> !teamInList.getTeamId().equals(team.getTeamId()))
            .collect(Collectors.toList());
    teams.clear();
    teams.addAll(tmp);
    return team;
  }
}
