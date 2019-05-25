package fi.joufa.agile;

import fi.joufa.agilesurvey.AgileApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AgileApplication.class)
@ActiveProfiles("development")
public class AgileApplicationTest {

  @Test
  public void contextLoads() {}
}
