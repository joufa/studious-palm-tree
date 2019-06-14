package fi.joufa.databaserepository.repository;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.*;

import fi.joufa.databaserepository.config.DatabaseConfiguration;
import fi.joufa.databaserepository.mapper.DomainToEntityMapper;
import fi.joufa.domain.model.Team;
import fi.joufa.domain.model.TeamBuilder;
import java.time.LocalDateTime;
import javax.persistence.EntityManager;
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

  @Test
  public void injectedComponentsAreNotNull() {
    assertThat(entityManager).isNotNull();
    assertThat(teamEntityRepository).isNotNull();
  }

  @Test
  public void create() {
    Team team =
        new TeamBuilder()
            .setName("Nakki")
            .setCreatedAt(LocalDateTime.now())
            .setUpdatedAt(LocalDateTime.now())
            .createTeam();
    teamEntityRepository.save(dem.teamToTeamEntity(team));
    teamEntityRepository.save(dem.teamToTeamEntity(team));
  }
}
