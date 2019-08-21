package fi.joufa.databaserepository.repository.impl;

import fi.joufa.databaserepository.mapper.SurveyEntityMapper;
import fi.joufa.databaserepository.model.SurveyEntity;
import fi.joufa.databaserepository.repository.SurveyEntityRepository;
import fi.joufa.domain.model.Survey;
import fi.joufa.domain.model.common.SurveyId;
import fi.joufa.repositoryinterface.SurveyRepositoryI;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;

public class SurveyRepositoryImpl implements SurveyRepositoryI {

  private SurveyEntityMapper sem;
  private SurveyEntityRepository surveyEntityRepository;

  @Inject
  public SurveyRepositoryImpl(
      SurveyEntityMapper sem, SurveyEntityRepository surveyEntityRepository) {
    this.sem = sem;
    this.surveyEntityRepository = surveyEntityRepository;
  }

  @Override
  public Survey save(Survey survey) {
    final SurveyEntity se = sem.surveyToEntity(survey);

    final SurveyEntity saved = surveyEntityRepository.save(se);

    final Survey survey1 = sem.entityToSurvey(saved);

    return survey1;
  }

  @Override
  public List<Survey> findAll() {
    return surveyEntityRepository.findAll().stream()
        .map(s -> sem.entityToSurvey(s))
        .collect(Collectors.toList());
  }

  @Override
  public List<Survey> findAllOpen() {
    return Collections.emptyList();
  }

  @Override
  public Survey findById(SurveyId surveyId) {
    final Optional<SurveyEntity> se = surveyEntityRepository.findById(surveyId.get());
    if (se.isPresent()) {
      return sem.entityToSurvey(se.get());
    } else {
      return null;
    }
  }

  @Override
  public Survey findByName(String name) {
    return null;
  }
}
