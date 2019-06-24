package fi.joufa.agilelogic.services;

import fi.joufa.agileservices.exceptions.AgileException;
import fi.joufa.agileservices.services.SurveyService;
import fi.joufa.domain.model.QuestionSet;
import fi.joufa.domain.model.Survey;
import fi.joufa.domain.model.SurveyFactory;
import fi.joufa.domain.model.common.SurveyId;
import fi.joufa.repositoryinterface.SurveyRepositoryI;
import java.util.Collections;
import java.util.List;
import java.util.Map;
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
    return Collections.emptyList();
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

    // check if is persisted
    final Survey present = surveyRepository.findById(survey.getSurveyId());

    return null;
  }

  @Override
  public Survey update(SurveyId surveyId, QuestionSet qs) throws AgileException {
    final Survey present = surveyRepository.findById(surveyId);
    Map<Integer, QuestionSet> oldSets = present.getQuestionSet();
    if (oldSets.containsValue(qs)) {
      // preset
    }
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
