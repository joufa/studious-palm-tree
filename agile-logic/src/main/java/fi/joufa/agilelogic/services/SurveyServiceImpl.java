package fi.joufa.agilelogic.services;

import fi.joufa.agileservices.exceptions.AgileException;
import fi.joufa.agileservices.services.SurveyService;
import fi.joufa.domain.model.Survey;
import fi.joufa.domain.model.SurveyFactory;
import fi.joufa.domain.model.common.SurveyId;
import java.util.List;

public class SurveyServiceImpl implements SurveyService {
  @Override
  public List<Survey> findAll() {
    return null;
  }

  /**
   * find surveys that can accept answers
   *
   * @return
   */
  @Override
  public List<Survey> findOpen() {
    return null;
  }

  public boolean isOpen(Survey survey) {
    return false;
  }

  @Override
  public Survey update(final Survey survey) {
    // The use case is creating and deleting questions from sets
    // A new set cannot be empty
    // Opening a survey for answers
    // Closing and reopening
    // Answers must have the id of survey
    return null;
  }

  @Override
  public Survey create(String name) throws AgileException {
    // Save and return saved instance
    // Cannot save with same name
    return SurveyFactory.createNew();
  }

  @Override
  public Survey findOne(SurveyId surveyId) {
    return null;
  }
}
