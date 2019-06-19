package fi.joufa.agilelogic.services;

import static fi.joufa.agilelogic.services.TeamRepositoryStub.addTeam;
import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.fail;

import fi.joufa.agileservices.exceptions.AgileException;
import fi.joufa.domain.model.StatusFactory;
import fi.joufa.domain.model.Team;
import fi.joufa.domain.model.TeamBuilder;
import fi.joufa.repositoryinterface.TeamRepositoryI;
import java.util.List;
import java.util.Optional;
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
    final Optional<Team> team = teamService.findTeamByName("Testi");
    assertThat(team.isPresent()).isEqualTo(true);
  }

  @Test
  public void findTeam_returnsTeam_notFound() {
    final Optional<Team> team = teamService.findTeamByName("Testi kakkonen");
    assertThat(team.isPresent()).isEqualTo(false);
  }

  @Test
  public void createNewTeam_success() {
    final Team team =
        new TeamBuilder()
            .setName("Kissalan pojat")
            .setMemberCount(3)
            .setDescription("Kissalan tiimi")
            .createTeam();
    final Team createdTeam = teamRepository.createTeam(team);
    assertThat(createdTeam.getName()).isEqualTo("Kissalan pojat");
  }

  @Test
  public void editTeam_updatesTeamData() {
    try {
      final Integer baseSize = teamRepository.findAll().size();
      final Optional<Team> existingTeam = teamService.findTeamByName("Testi");
      if (!existingTeam.isPresent()) {
        fail();
      }
      final Team newTeam =
          new TeamBuilder()
              .setTeamId(existingTeam.get().getTeamId())
              .setName("Testi")
              .setMemberCount(6)
              .setDescription("Kuvausta")
              .setStatusHistory(StatusFactory.createHistory())
              .createTeam();

      final Team result = teamService.editTeam(newTeam);

      final Integer afterSize = teamRepository.findAll().size();
      assertThat(afterSize).isEqualTo(baseSize);
      assertThat(result.getDescription()).isEqualTo("Kuvausta");
    } catch (AgileException e) {
      fail(String.format("Error in updating a team: %s", e.getMessage()));
    }
  }

  @Test
  public void deleteTeam_deletesTeam() {
    try {
      final Team deletedTeam =
          teamService.deleteTeam(new TeamBuilder().setName("Testi").createTeam());
      assertThat(deletedTeam.getName()).isEqualTo("Testi");
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
