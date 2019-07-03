package fi.joufa.databaserepository.mapper;

import fi.joufa.databaserepository.model.SurveyEntity;
import fi.joufa.domain.model.Survey;
import fi.joufa.domain.model.SurveyBuilder;

public class SurveyEntityMapper {
  public SurveyEntity surveyToEntity(Survey survey) {
    final SurveyEntity se = new SurveyEntity();
    se.setId(survey.getSurveyId() != null ? survey.getSurveyId().get() : null);
    se.setName(survey.getName());
    return se;
  }

  public Survey entityToSurvey(SurveyEntity se) {
    return new SurveyBuilder().setSurveyId(se.getId()).setName(se.getName()).createSurvey();
  }
}
