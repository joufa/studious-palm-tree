package fi.joufa.spring.configuration;

import fi.joufa.agilelogic.services.SurveyServiceImpl;
import fi.joufa.repositoryinterface.SurveyRepositoryI;
import fi.joufa.repositoryinterface.TeamRepositoryI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SurveyService extends SurveyServiceImpl {
  public SurveyService(@Autowired SurveyRepositoryI repo, @Autowired TeamRepositoryI teamRepo) {
    super(repo, teamRepo);
  }
}
