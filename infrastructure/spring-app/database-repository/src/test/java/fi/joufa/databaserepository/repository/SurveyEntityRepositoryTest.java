package fi.joufa.databaserepository.repository;

import static org.assertj.core.api.Assertions.assertThat;

import fi.joufa.databaserepository.config.DatabaseConfiguration;
import fi.joufa.databaserepository.mapper.SurveyEntityMapper;
import fi.joufa.databaserepository.model.SurveyEntity;
import fi.joufa.domain.model.*;
import fi.joufa.domain.model.common.TeamId;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.EntityManager;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = DatabaseConfiguration.class)
@ActiveProfiles("test")
@TestPropertySource(locations = "classpath:application-test.properties")
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
    QuestionMap<Question> questions =
        QuestionMap.createQuestionMap(Arrays.asList(new Question("Moro")));
    QuestionSet set = QuestionSet.create("Eka", questions);
    QuestionMap<QuestionSet> sets = QuestionMap.createQuestionMap(Arrays.asList(set));
    survey.update(sets);
    Set<TeamId> teams = new HashSet<>();
    teams.add(new TeamId(Long.valueOf(3)));
    survey.update(teams);
    final SurveyEntity se = sem.surveyToEntity(survey);
    surveyEntityRepository.save(se);
    final SurveyEntity debug = surveyEntityRepository.findById(Long.valueOf(1)).get();
    final Survey constructed =
        sem.entityToSurvey(surveyEntityRepository.findById(Long.valueOf(1)).get());
    System.out.println(constructed);
  }
}
