package fi.joufa.spring.configuration;

import static org.junit.Assert.*;

import fi.joufa.repositoryinterface.TeamRepositoryI;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TeamService.class)
public class TeamServiceTest {

  @MockBean private TeamRepositoryI teamRepositoryI;

  @Autowired private TeamService teamService;

  @Test
  public void teamServiceBean_loadsToContext() {
    assertNotNull(teamService);
  }
}
