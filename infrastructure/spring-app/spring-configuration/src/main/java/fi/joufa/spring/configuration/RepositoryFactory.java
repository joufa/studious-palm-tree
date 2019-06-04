package fi.joufa.spring.configuration;

import fi.joufa.databaserepository.mapper.DomainToEntityMapper;
import fi.joufa.databaserepository.repository.TeamEntityRepository;
import fi.joufa.databaserepository.repository.TeamRepositoryImpl;
import fi.joufa.repositoryinterface.TeamRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/** @author udanre */
@Configuration
public class RepositoryFactory {
  @Bean
  public TeamRepository teamRepository(
      DomainToEntityMapper domainToEntityMapper, TeamEntityRepository teamEntityRepository) {
    return new TeamRepositoryImpl(domainToEntityMapper, teamEntityRepository);
  }
}
