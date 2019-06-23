package fi.joufa.agilelogic.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import fi.joufa.domain.model.Survey;
import fi.joufa.domain.model.common.SurveyId;
import fi.joufa.repositoryinterface.SurveyRepositoryI;
import org.junit.Before;
import org.junit.Test;

public class SurveyServiceImplTest {

  private SurveyServiceImpl surveyService;
  private SurveyRepositoryI surveyRepository;

  @Before
  public void init() {
    this.surveyRepository = new SurveyRepositoryStub();
    this.surveyService = new SurveyServiceImpl(this.surveyRepository);
  }

  @Test
  public void surveyService_createNew_returnsPersistedSurvey() {
    try {
      final Survey survey = surveyService.create("First Survey");
      assertEquals(new SurveyId(Long.valueOf(1)), survey.getSurveyId());
      assertEquals(1, surveyService.findAll().size());
    } catch (Exception ex) {
      fail();
    }
  }
}
