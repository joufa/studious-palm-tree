package fi.joufa.springwebapp.application;

import static org.junit.Assert.*;

import fi.joufa.agileservices.exceptions.AgileException;
import fi.joufa.spring.configuration.TeamService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class AgileApplicationTest {

  @Autowired private TeamService teamService;

  @Test
  public void test() throws AgileException {
    assertNotNull(teamService);
  }
}
