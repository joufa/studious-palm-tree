package fi.joufa.agilelogic.services;

import static fi.joufa.agilelogic.services.TeamRepositoryStub.addTeam;
import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.fail;

import fi.joufa.agileservices.exceptions.AgileException;
import fi.joufa.domain.model.Team;
import fi.joufa.repositoryinterface.TeamRepositoryI;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class TeamServiceTest {

  private TeamServiceImpl teamService;
  private TeamRepositoryI teamRepository;

  @Before
  public void init() {
    this.teamRepository = new TeamRepositoryStub(addTeam());
    this.teamService = new TeamServiceImpl(this.teamRepository);
  }

  @Test
  public void findTeam_returnsTeam_success() {
    try {
      final Team team = teamService.findTeamById(Long.valueOf(1));
      assertThat(team.getTeamId()).isEqualTo(Long.valueOf(1));
    } catch (AgileException e) {
      fail(String.format("Error in finding teams: %s", e.getMessage()));
    }
  }

  @Test(expected = AgileException.class)
  public void findTeam_returnsTeam_notFound() throws Exception {
    final Team team = teamService.findTeamById(Long.valueOf(2));
  }

  @Test
  public void createNewTeam_success() {
    final Team team = new Team(null, "Kissalan pojat", 3, "Kissalan tiimi");
    final Team createdTeam = teamRepository.createTeam(team);
    assertThat(createdTeam.getTeamId()).isNotNull();
  }

  @Test(expected = AgileException.class)
  public void createNewTeam_failure() throws Exception {
    final Team team = new Team(null, "Testi", 3, "Kissalan tiimi");
    teamService.createTeam(team);
  }

  @Test
  public void editTeam_updatesTeamData() {
    try {
      final Team team = teamService.findTeamById(Long.valueOf(1));
      final Team newTeam = new Team(team.getTeamId(), "Uusi nimi", 6, "Uusi kuvaus");
      final Team updatedTeam = teamService.editTeam(newTeam);
      assertThat(updatedTeam.getTeamId()).isEqualTo(Long.valueOf(1));
      assertThat(updatedTeam.getName()).isEqualTo("Uusi nimi");
    } catch (AgileException e) {
      fail(String.format("Error in updating a team: %s", e.getMessage()));
    }
  }

  @Test
  public void deleteTeam_deletesTeam() {
    try {
      final Team deletedTeam = teamService.deleteTeam(Long.valueOf(1));
      assertThat(deletedTeam.getTeamId()).isEqualTo(Long.valueOf(1));
      assertThat(teamService.findAll()).isEmpty();
    } catch (AgileException e) {
      fail(String.format("Error in deleting a team: %s", e.getMessage()));
    }
  }

  @Test
  public void findAll_returnsListOfTeams() {
    final List<Team> teams = teamService.findAll();
    assertThat(teams).hasSize(1);
  }
}
