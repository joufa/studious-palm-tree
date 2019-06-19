package fi.joufa.databaserepository.repository;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.*;

import fi.joufa.databaserepository.config.DatabaseConfiguration;
import fi.joufa.databaserepository.mapper.DomainToEntityMapper;
import fi.joufa.domain.model.StatusHistory;
import fi.joufa.domain.model.Team;
import fi.joufa.domain.model.TeamBuilder;
import java.time.LocalDateTime;
import javax.persistence.EntityManager;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = DatabaseConfiguration.class)
@ActiveProfiles("test")
@DataJpaTest
public class TeamEntityRepositoryTest {

  @Autowired private EntityManager entityManager;
  @Autowired private TeamEntityRepository teamEntityRepository;
  private DomainToEntityMapper dem = new DomainToEntityMapper();

  @Before
  public void init() {}

  @Test
  public void injectedComponentsAreNotNull() {
    assertThat(entityManager).isNotNull();
    assertThat(teamEntityRepository).isNotNull();
  }

  @Test
  public void createAnEntity() {
    Team team =
        new TeamBuilder()
            .setName("Nakki")
            .setStatusHistory(new StatusHistory(LocalDateTime.now(), (LocalDateTime.now())))
            .createTeam();
    teamEntityRepository.save(dem.teamToTeamEntity(team));
  }

  @Test
  public void findAnEntity() {
    Team team =
        new TeamBuilder()
            .setName("Nakki")
            .setStatusHistory(new StatusHistory(LocalDateTime.now(), (LocalDateTime.now())))
            .createTeam();
    teamEntityRepository.save(dem.teamToTeamEntity(team));

    final Team foundTeam = dem.teamEntityToTeam(teamEntityRepository.findTeamEntityByName("Nakki"));
    assertThat(foundTeam.getName()).isEqualTo("Nakki");
  }

  @Test
  public void updateAnEntity() {
    Team team =
        new TeamBuilder()
            .setName("Nakki")
            .setStatusHistory(new StatusHistory(LocalDateTime.now(), (LocalDateTime.now())))
            .createTeam();

    teamEntityRepository.save(dem.teamToTeamEntity(team));
    final Team foundTeam = dem.teamEntityToTeam(teamEntityRepository.findTeamEntityByName("Nakki"));
    final Team updatedTeam =
        new TeamBuilder()
            .setTeamId(foundTeam.getTeamId())
            .setName(foundTeam.getName())
            .setMemberCount(8)
            .setStatusHistory(new StatusHistory(LocalDateTime.now(), (LocalDateTime.now())))
            .createTeam();

    teamEntityRepository.save(dem.teamToTeamEntity(updatedTeam));

    final Integer size = teamEntityRepository.findAll().size();
    assertThat(1).isEqualTo(size);
  }
}
