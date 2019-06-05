package fi.joufa.spring.configuration;

import fi.joufa.agilelogic.services.TeamServiceImpl;
import fi.joufa.agileservices.services.TeamService;
import fi.joufa.repositoryinterface.TeamRepositoryI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/** @author udanre */
@Configuration
public class ApplicationLogicFactory {

  @Bean
  public TeamService teamService(TeamRepositoryI teamRepositoryI) {
    return new TeamServiceImpl(teamRepositoryI);
  }
}
