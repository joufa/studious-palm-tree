package fi.joufa.agilelogic.services;

import fi.joufa.agileservices.exceptions.AgileException;
import fi.joufa.agileservices.services.SurveyService;
import fi.joufa.domain.model.*;
import fi.joufa.domain.model.common.SurveyId;
import fi.joufa.domain.model.common.TeamId;
import fi.joufa.repositoryinterface.SurveyRepositoryI;
import fi.joufa.repositoryinterface.TeamRepositoryI;
import java.time.LocalDateTime;
import java.util.*;
import javax.inject.Inject;

public class SurveyServiceImpl implements SurveyService {

  private final SurveyRepositoryI surveyRepository;
  private final TeamRepositoryI teamRepository;

  @Inject
  public SurveyServiceImpl(SurveyRepositoryI surveyRepository, TeamRepositoryI teamRepository) {
    this.surveyRepository = surveyRepository;
    this.teamRepository = teamRepository;
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
      // Update

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
      throw new AgileException("Cannot create survey: " + ex);
    }
  }

  @Override
  public Survey update(SurveyUpdate surveyUpdate) throws AgileException {
    Set teamsUpdate = null;
    Survey survey = surveyRepository.findById(surveyUpdate.getId());
    System.out.print(survey);
    if (survey == null) {
      throw new AgileException("Cannot find survey for update");
    }
    if (survey.isOpen()) {
      throw new AgileException("Survey is open and therefore cannot be modified");
    }

    // Changes in teams
    if (surveyUpdate.getTeams() != null) {
      teamsUpdate = this.fixTeamsForUpdate(survey.getTeams(), surveyUpdate.getTeams());
    }

    // Update tags
    StatusHistory sh =
        new StatusHistory(survey.getStatusHistory().getCreatedAt(), LocalDateTime.now());
    final Survey finalSurvey =
        new SurveyBuilder()
            .setName(survey.getName())
            .setAllTeams(teamsUpdate)
            .setSurveyId(survey.getSurveyId().get())
            .setStatus(survey.getStatus())
            .setHistory(survey.getSurveyHistory())
            .setQuestionSets(survey.getQuestionSets())
            .setStatusHistory(sh)
            .createSurvey();

    return surveyRepository.save(finalSurvey);
  }

  @Override
  public Survey createFrom(SurveyId surveyId) throws AgileException {
    return null;
  }

  @Override
  public Optional<Survey> findOne(SurveyId surveyId) {
    return Optional.of(this.surveyRepository.findById(surveyId));
  }

  private Set<TeamId> fixTeamsForUpdate(Set<TeamId> oldTeams, Set<TeamId> newTeams) {
    if (newTeams == null) {
      return oldTeams == null ? Collections.emptySet() : oldTeams;
    }

    if (oldTeams == null) {
      return newTeams;
    }

    oldTeams.addAll(newTeams);

    return oldTeams;
  }
}
