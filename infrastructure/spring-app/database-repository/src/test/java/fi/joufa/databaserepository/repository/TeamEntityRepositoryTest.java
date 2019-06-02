package fi.joufa.databaserepository.repository;

import static org.junit.Assert.*;

import fi.joufa.databaserepository.config.DatabaseConfiguration;
import javax.persistence.EntityManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = DatabaseConfiguration.class)
@DataJpaTest
public class TeamEntityRepositoryTest {

  @Autowired private EntityManager entityManager;
  @Autowired private TeamEntityRepository teamEntityRepository;

  @Test
  public void injectedComponentsAreNotNull() {
    assertThat(entityManager).isNotNull();
    assertThat(teamEntityRepository).isNotNull();

  }
}
