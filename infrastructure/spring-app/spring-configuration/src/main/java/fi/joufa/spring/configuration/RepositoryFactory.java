package fi.joufa.spring.configuration;

import fi.joufa.databaserepository.mapper.DomainToEntityMapper;
import fi.joufa.databaserepository.mapper.SurveyEntityMapper;
import fi.joufa.databaserepository.repository.SurveyEntityRepository;
import fi.joufa.databaserepository.repository.TeamEntityRepository;
import fi.joufa.databaserepository.repository.impl.SurveyRepositoryImpl;
import fi.joufa.databaserepository.repository.impl.TeamRepositoryImpl;
import fi.joufa.repositoryinterface.SurveyRepositoryI;
import fi.joufa.repositoryinterface.TeamRepositoryI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepositoryFactory {
  @Bean
  public TeamRepositoryI teamRepository(
      DomainToEntityMapper domainToEntityMapper, TeamEntityRepository teamEntityRepository) {
    return new TeamRepositoryImpl(domainToEntityMapper, teamEntityRepository);
  }

  @Bean
  public SurveyRepositoryI surveyRepository(
      SurveyEntityMapper sem, SurveyEntityRepository surveyEntityRepository) {
    return new SurveyRepositoryImpl(sem, surveyEntityRepository);
  }
}
