package fi.joufa.agile.repository;

import static org.junit.Assert.*;

import fi.joufa.agilesurvey.AgileApplication;
import fi.joufa.agilesurvey.domain.Team;
import fi.joufa.agilesurvey.repository.TeamRepository;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AgileApplication.class)
@ActiveProfiles("development")
public class TeamRepositoryIT {

  @Autowired
  @SuppressWarnings("unused")
  private TeamRepository teamRepository;

  @Test
  public void saveTeam_should_persist_a_team() {
    Team team = new Team();
    team.setName("KiePo");
    teamRepository.save(team);
  }

  @Test
  public void findAll_should_retrieve_all_teams() {
    final List<Team> teams = teamRepository.findAll();
    assertEquals(4, teams.size());
  }

  @Test
  public void team_should_be_retrieved_by_id() {
    final Optional<Team> secondTeam = teamRepository.findById(Long.valueOf(2));
    assertNotNull(secondTeam.get());
    assertEquals("Kissalan pojat", secondTeam.get().getName());
  }

  @Test(expected = DataIntegrityViolationException.class)
  public void team_name_should_be_unique() {

    Team team = new Team();
    team.setName("Kissalan pojat");

    teamRepository.save(team);
  }

  @Test
  public void team_has_created_and_updated_timestamps() {
    Optional<Team> team1 = teamRepository.findById(Long.valueOf(1));

    assertTrue(team1.get().getCreated() instanceof Date);

    Team team = team1.get();

    team.setName("Testijengi");

    teamRepository.save(team);

    team1 = teamRepository.findById(Long.valueOf(1));

    assertTrue(team1.get().getUpdated() instanceof Date);
  }
}
