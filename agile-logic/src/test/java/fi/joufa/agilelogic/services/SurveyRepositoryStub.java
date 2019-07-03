package fi.joufa.agilelogic.services;

import fi.joufa.domain.model.*;
import fi.joufa.domain.model.common.SurveyId;
import fi.joufa.repositoryinterface.SurveyRepositoryI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SurveyRepositoryStub implements SurveyRepositoryI {

  private List<Survey> surveys;
  private Integer sequence = 1;

  public SurveyRepositoryStub(Survey survey) {
    this.surveys = new ArrayList<>();
    this.surveys.add(survey);
  }

  @Override
  public Survey save(Survey survey) {
    boolean isPresent = false;
    if (survey.getSurveyId() != null) {
      final Survey existing = this.surveys.stream().filter(x -> x.equals(survey)).findFirst().get();
      isPresent = true;
    }
    if (!isPresent) {

      final Survey save =
          new SurveyBuilder()
              .setSurveyId(Long.valueOf(sequence + 1))
              .setAllTeams(survey.getTeams())
              .setName(survey.getName())
              .setQuestionSets(survey.getQuestionSets())
              .setHistory(survey.getSurveyHistory())
              .setStatusHistory(survey.getStatusHistory())
              .setStatus(survey.getStatus())
              .createSurvey();
      this.surveys.add(save);
      return save;
    } else {
      List<Survey> tmp =
          surveys.stream()
              .filter(surveyInList -> !surveyInList.equals(survey))
              .collect(Collectors.toList());
      surveys.clear();
      surveys.addAll(tmp);
      final Survey save =
          new SurveyBuilder()
              .setSurveyId(survey.getSurveyId().get())
              .setAllTeams(survey.getTeams())
              .setName(survey.getName())
              .setQuestionSets(survey.getQuestionSets())
              .setHistory(survey.getSurveyHistory())
              .setStatusHistory(survey.getStatusHistory())
              .setStatus(survey.getStatus())
              .createSurvey();
      this.surveys.add(save);
      return save;
    }
  }

  @Override
  public List<Survey> findAll() {
    return this.surveys;
  }

  @Override
  public List<Survey> findAllOpen() {
    return this.surveys.stream().filter(x -> x.getStatus().isOpen()).collect(Collectors.toList());
  }

  @Override
  public Survey findById(SurveyId surveyId) {
    return this.surveys.stream()
        .filter(survey -> survey.getSurveyId().equals(surveyId))
        .findFirst()
        .get();
  }

  @Override
  public Survey findByName(String name) {
    return this.surveys.stream().filter(x -> x.getName().equals(name)).findFirst().get();
  }

  protected static Survey addOne() {
    final QuestionMap<Question> questions =
        QuestionMap.createQuestionMap(Arrays.asList(new Question("Moro?")));
    final QuestionSet set1 = QuestionSet.create("Ekat kysymykset", questions);
    final QuestionMap<QuestionSet> sets = QuestionMap.createQuestionMap(Arrays.asList(set1));
    return new SurveyBuilder()
        .setName("Test survey")
        .setSurveyId(Long.valueOf(1))
        .setTeams(Long.valueOf(1))
        .setQuestionSets(sets)
        .initStatus()
        .createSurvey();
  }
}
