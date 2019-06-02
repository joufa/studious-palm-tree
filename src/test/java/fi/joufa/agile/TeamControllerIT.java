package fi.joufa.agile;

import static org.junit.Assert.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import fi.joufa.agilesurvey.AgileApplication;
import fi.joufa.agilesurvey.model.Team;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("development")
@ContextConfiguration(classes = AgileApplication.class)
public class TeamControllerIT {

  @LocalServerPort private int port;

  private ObjectMapper objectMapper = new ObjectMapper();

  TestRestTemplate restTemplate = new TestRestTemplate();

  HttpHeaders headers = new HttpHeaders();

  @Test
  public void GET_ApiTeams_shouldReturnListOfTeams() throws Exception {
    HttpEntity<String> entity = new HttpEntity<String>(null, headers);

    ResponseEntity<String> response =
        restTemplate.exchange(
            createURLWithPort("/api/teams"), HttpMethod.GET, entity, String.class);

    List<Team> expected = objectMapper.readValue(response.getBody(), List.class);

    assertEquals(4, expected.size());
  }

  @Test
  public void POST_ApiTeams_shouldCreateNewTeam() throws Exception {
    final Team teamToPost = new Team();
    teamToPost.setName("Tiimi1");
    final String JSON = objectMapper.writeValueAsString(teamToPost);
    headers.setContentType(MediaType.APPLICATION_JSON);
    HttpEntity<String> entity = new HttpEntity<String>(JSON, headers);

    ResponseEntity<String> response =
        restTemplate.exchange(
            createURLWithPort("/api/teams"), HttpMethod.POST, entity, String.class);
    System.out.println(response.getBody());
    final Team expected = objectMapper.readValue(response.getBody(), Team.class);

    assertEquals(teamToPost.getName(), expected.getName());
    assertNotNull(expected.getCreated());
    assertNotNull(expected.getId());
  }

  @Test
  public void GET_ApiTeams_shouldGiveOneTeam() throws Exception {
    HttpEntity<String> entity = new HttpEntity<String>(null, headers);

    ResponseEntity<String> response =
        restTemplate.exchange(
            createURLWithPort("/api/teams/1"), HttpMethod.GET, entity, String.class);
    System.out.println(response.getBody());
    final Team expected = objectMapper.readValue(response.getBody(), Team.class);

    assertNotNull(expected);
  }

  private String createURLWithPort(String uri) {
    return "http://localhost:" + port + uri;
  }
}
