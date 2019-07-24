package fi.joufa.agilelogic.services;

import fi.joufa.agileservices.exceptions.AgileException;
import fi.joufa.agileservices.services.SurveyService;
import fi.joufa.domain.model.*;
import fi.joufa.domain.model.common.SurveyId;
import fi.joufa.domain.model.common.TeamId;
import fi.joufa.repositoryinterface.SurveyRepositoryI;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;
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

  @Override
  public List<Survey> findAllOpen() {

    return Collections.emptyList();
  }

  public boolean isOpen(Survey survey) {
    final Survey persisted = surveyRepository.findById(survey.getSurveyId());
    return persisted.isOpen();
  }

  @Override
  public Survey update(final Survey survey) throws AgileException {
    try {
      final Survey present = surveyRepository.findById(survey.getSurveyId());
      if (present == null || survey.getSurveyId() == null) {
        throw new IllegalArgumentException("Cannot find survey");
      }

      final Set<TeamId> teams =
          survey.getTeams().equals(present.getTeams()) ? present.getTeams() : survey.getTeams();
      final QuestionMap<QuestionSet> qm =
          present.getQuestionSets().equals(survey.getQuestionSets())
              ? present.getQuestionSets()
              : survey.getQuestionSets();

      final Survey updated =
          new SurveyBuilder()
              .setSurveyId(present.getSurveyId().get())
              .setName(present.getName())
              .setAllTeams(teams)
              .setQuestionSets(qm)
              .setStatusHistory(StatusFactory.update(survey.getStatusHistory()))
              .setStatus(survey.getStatus())
              .setHistory(survey.getSurveyHistory())
              .createSurvey();
      return surveyRepository.save(updated);
    } catch (Exception e) {
      throw new AgileException(e.getMessage());
    }
  }

  @Override
  public Survey create(String name) throws AgileException {
    try {
      return surveyRepository.save(SurveyFactory.createNew(name));
    } catch (Exception ex) {
      throw new AgileException("Cannot create survey");
    }
  }

  @Override
  public Survey createFrom(SurveyId surveyId) throws AgileException {
    return null;
  }

  @Override
  public Optional<Survey> findOne(SurveyId surveyId) {
    return Optional.of(this.surveyRepository.findById(surveyId));
  }
}
