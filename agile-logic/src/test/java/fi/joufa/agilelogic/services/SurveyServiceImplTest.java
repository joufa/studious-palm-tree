package fi.joufa.agilelogic.services;

import static org.junit.Assert.*;

import fi.joufa.agileservices.exceptions.AgileException;
import fi.joufa.agileservices.services.SurveyService;
import fi.joufa.domain.model.*;
import fi.joufa.domain.model.common.SurveyId;
import fi.joufa.domain.model.common.TeamId;
import fi.joufa.repositoryinterface.SurveyRepositoryI;
import fi.joufa.repositoryinterface.TeamRepositoryI;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.junit.Before;
import org.junit.Test;

public class SurveyServiceImplTest {

  private SurveyRepositoryI surveyRepository;
  private SurveyService surveyService;
  private TeamRepositoryI teamRepository;

  @Before
  public void init() {
    this.surveyRepository = new SurveyRepositoryStub(SurveyRepositoryStub.addOne());
    this.teamRepository = new TeamRepositoryStub(TeamRepositoryStub.addTeam());
    this.surveyService = new SurveyServiceImpl(this.surveyRepository, this.teamRepository);
  }

  @Test
  public void findAll() {
    assertEquals(1, this.surveyService.findAll().size());
  }

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
  public void updateFromSurveyUpdate() throws AgileException {
    surveyService.create("Updatable Survey");
    Survey survey = surveyService.findOne(new SurveyId(Long.valueOf(2))).get();
    SurveyUpdate su = new SurveyUpdate(new SurveyId(Long.valueOf(2)));
    Set<TeamId> teams = new HashSet<>();
    teams.add(new TeamId(Long.valueOf(1)));
    su.setTeams(teams);
    final Survey updated = surveyService.update(su);
    assertNotNull(updated);
    assertEquals(teams, updated.getTeams());
  }


  private QuestionMap<QuestionSet> createQm() {
    final QuestionMap<Question> questions =
        QuestionMap.createQuestionMap(Arrays.asList(new Question("Eka"), new Question("Toka")));
    final QuestionSet firstSet = QuestionSet.create("Eka setti", questions);
    return QuestionMap.createQuestionMap(Arrays.asList(firstSet));
  }
}
