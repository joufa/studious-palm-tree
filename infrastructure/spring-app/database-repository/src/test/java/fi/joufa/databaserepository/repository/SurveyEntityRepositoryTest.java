package fi.joufa.databaserepository.repository;

import static org.assertj.core.api.Assertions.assertThat;

import fi.joufa.databaserepository.config.DatabaseConfiguration;
import fi.joufa.databaserepository.mapper.SurveyEntityMapper;
import fi.joufa.databaserepository.model.SurveyEntity;
import fi.joufa.domain.model.Survey;
import fi.joufa.domain.model.SurveyFactory;
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
public class SurveyEntityRepositoryTest {
  @Autowired private EntityManager entityManager;
  @Autowired private SurveyEntityRepository surveyEntityRepository;
  private SurveyEntityMapper sem = new SurveyEntityMapper();

  @Before
  public void init() {}

  @Test
  public void injectedComponentsAreNotNull() {
    assertThat(entityManager).isNotNull();
    assertThat(surveyEntityRepository).isNotNull();
  }

  @Test
  public void createSurvey() {
    final Survey survey = SurveyFactory.createNew("Test");
    final SurveyEntity se = sem.surveyToEntity(survey);
    surveyEntityRepository.save(se);
  }
}
