package fi.joufa.agilelogic.services;

import fi.joufa.agileservices.exceptions.AgileException;
import fi.joufa.agileservices.services.SurveyService;
import fi.joufa.domain.model.QuestionSet;
import fi.joufa.domain.model.Survey;
import fi.joufa.domain.model.SurveyFactory;
import fi.joufa.domain.model.common.SurveyId;
import fi.joufa.repositoryinterface.SurveyRepositoryI;
import java.util.List;
import javax.inject.Inject;

public class SurveyServiceImpl implements SurveyService {

  private final SurveyRepositoryI surveyRepository;

  @Inject
  public SurveyServiceImpl(SurveyRepositoryI surveyRepository) {
    this.surveyRepository = surveyRepository;
  }

  @Override
  public List<Survey> findAll() {
    return surveyRepository.findAll();
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
    final Survey persisted = surveyRepository.findById(survey.getSurveyId());
    return persisted.isOpen();
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
  public Survey update(SurveyId surveyId, QuestionSet qs) throws AgileException {
    return null;
  }

  @Override
  public Survey create(String name) throws AgileException {
    // Save and return saved instance
    // Cannot save with same name
    try {
      return surveyRepository.save(SurveyFactory.createNew(name));
    } catch (Exception ex) {
      throw new AgileException("Cannot create survey");
    }
  }

  @Override
  public Survey findOne(SurveyId surveyId) {
    return null;
  }
}
