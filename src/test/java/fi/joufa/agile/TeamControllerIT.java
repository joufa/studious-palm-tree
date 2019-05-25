package fi.joufa.agile;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import fi.joufa.agilesurvey.AgileApplication;
import fi.joufa.agilesurvey.TeamController;
import fi.joufa.agilesurvey.domain.Team;
import fi.joufa.agilesurvey.repository.TeamRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(TeamController.class)
@ActiveProfiles("development")
@ContextConfiguration(classes = AgileApplication.class)
public class TeamControllerIT {

  @Autowired
  @SuppressWarnings("unused")
  private MockMvc mockMvc;

  @MockBean
  @SuppressWarnings("unused")
  private TeamRepository teamRepository;

  @Test
  public void findTeams() throws Exception {

    given(teamRepository.findAll()).willReturn(createMockTeams());

    mockMvc
        .perform(get("/teams").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk());
  }

  private List<Team> createMockTeams() {
    final List<Team> teams = new ArrayList<>();
    Team team = new Team();
    team.setName("Kissalan pojat");
    team.setId(Long.valueOf(1));
    team.setCreated(new Date());
    teams.add(team);
    return teams;
  }
}
