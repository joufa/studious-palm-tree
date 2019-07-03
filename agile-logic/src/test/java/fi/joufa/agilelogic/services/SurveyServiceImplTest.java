package fi.joufa.agilelogic.services;

import static org.junit.Assert.*;

import fi.joufa.agileservices.exceptions.AgileException;
import fi.joufa.agileservices.services.SurveyService;
import fi.joufa.domain.model.*;
import fi.joufa.domain.model.common.SurveyId;
import fi.joufa.repositoryinterface.SurveyRepositoryI;
import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;

public class SurveyServiceImplTest {

  private SurveyRepositoryI surveyRepository;
  private SurveyService surveyService;

  @Before
  public void init() {
    this.surveyRepository = new SurveyRepositoryStub(SurveyRepositoryStub.addOne());
    this.surveyService = new SurveyServiceImpl(this.surveyRepository);
  }

  @Test
  public void findAll() {
    assertEquals(1, this.surveyService.findAll().size());
  }

  @Test
  public void findAllOpen() {}

  @Test
  public void isOpen() {}

  @Test
  public void update() throws AgileException {

    final Survey survey = surveyService.findOne(new SurveyId(Long.valueOf(1))).get();
    final QuestionMap<QuestionSet> originalSet = survey.getQuestionSets();
    System.out.println(survey.getQuestionSets());

    survey.update(this.createQm());

    final Survey update = surveyService.update(survey);

    assertEquals(1, surveyService.findAll().size());
    assertEquals(this.createQm(), update.getQuestionSets());
    assertFalse(originalSet.equals(update.getQuestionSets()));
    assertFalse(survey.getStatusHistory().equals(update.getStatusHistory()));
  }

  @Test
  public void create() throws AgileException {
    final Survey result = surveyService.create("Test Name");
    assertEquals(2, this.surveyService.findAll().size());
    assertNotNull(result.getStatusHistory());
    assertNotNull(result.getSurveyHistory());
    assertNotNull(result.getStatus());
    assertEquals("Test Name", result.getName());
  }

  @Test
  public void createFrom() {}

  @Test
  public void findOne() {}

  private QuestionMap<QuestionSet> createQm() {
    final QuestionMap<Question> questions =
        QuestionMap.createQuestionMap(Arrays.asList(new Question("Eka"), new Question("Toka")));
    final QuestionSet firstSet = QuestionSet.create("Eka setti", questions);
    return QuestionMap.createQuestionMap(Arrays.asList(firstSet));
  }
}
