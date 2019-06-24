package fi.joufa.spring.configuration;

import fi.joufa.agilelogic.services.TeamServiceImpl;
import fi.joufa.repositoryinterface.TeamRepositoryI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TeamService extends TeamServiceImpl {
  public TeamService(@Autowired TeamRepositoryI repo) {
    super(repo);
  }
}
