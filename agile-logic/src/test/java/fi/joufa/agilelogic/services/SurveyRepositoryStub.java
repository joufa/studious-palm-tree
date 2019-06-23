package fi.joufa.agilelogic.services;

import fi.joufa.domain.model.Survey;
import fi.joufa.domain.model.SurveyBuilder;
import fi.joufa.domain.model.common.SurveyId;
import fi.joufa.repositoryinterface.SurveyRepositoryI;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SurveyRepositoryStub implements SurveyRepositoryI {

  private List<Survey> surveys;
  private Integer sequence = 1;

  public SurveyRepositoryStub() {
    this.surveys = new ArrayList<>();
  }

  @Override
  public Survey save(Survey survey) {
    if (this.surveys.contains(survey)) {
      List<Survey> tmp =
          surveys.stream()
              .filter(teamInList -> !teamInList.equals(survey))
              .collect(Collectors.toList());
      surveys.clear();
      surveys.addAll(tmp);
      surveys.add(survey);
      return survey;
    } else {
      final Survey addition =
          new SurveyBuilder()
              .setSurveyId(new SurveyId(Long.valueOf(sequence)))
              .setTeams(survey.getTeams())
              .setQuestionSet(survey.getQuestionSet())
              .setStatus(survey.getStatus())
              .setStatusHistory(survey.getStatusHistory())
              .createSurvey();
      this.surveys.add(addition);
      this.sequence++;
      return addition;
    }
  }

  @Override
  public List<Survey> findAll() {
    return this.surveys;
  }

  @Override
  public Survey findById(SurveyId surveyId) {
    return this.surveys.stream()
        .filter(survey -> survey.getSurveyId().equals(surveyId))
        .findFirst()
        .get();
  }
}
