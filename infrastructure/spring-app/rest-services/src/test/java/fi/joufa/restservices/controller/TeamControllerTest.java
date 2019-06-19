package fi.joufa.restservices.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import fi.joufa.agileservices.services.TeamService;
import fi.joufa.domain.model.StatusFactory;
import fi.joufa.domain.model.StatusHistoryTypes;
import fi.joufa.domain.model.Team;
import fi.joufa.domain.model.TeamBuilder;
import fi.joufa.domain.model.common.TeamId;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TeamController.class)
@WebMvcTest
public class TeamControllerTest {

  @Autowired private MockMvc mvc;

  @MockBean private TeamService teamService;

  @Test
  public void givenTeams_whenGetTeams_thenReturnJsonArray() throws Exception {

    Team team =
        new TeamBuilder().setTeamId(new TeamId(Long.valueOf(1))).setName("Sipuli").createTeam();

    List<Team> allTeams = Arrays.asList(team);

    given(teamService.findAll()).willReturn(allTeams);

    mvc.perform(get("/api/teams").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$", hasSize(1)))
        .andExpect(jsonPath("$[0].name", is(team.getName())));
  }

  @Test
  public void givenTeams_whenCreateTeams_thenReturnJsonTeam() throws Exception {
    ObjectMapper mapper = new ObjectMapper();

    TeamRequestDto teamRequestDto = new TeamRequestDto();
    teamRequestDto.setName("Sipuli");

    final Team response = toTeam(teamRequestDto);

    given(teamService.createTeam(any(Team.class))).willReturn(response);

    mvc.perform(
            post("/api/teams")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(teamRequestDto)))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.name", is("Sipuli")));
  }

  // For testing purposes
  private Team toTeam(TeamRequestDto request) {
    final TeamId id = new TeamId(Long.valueOf(1));
    return new TeamBuilder()
        .setTeamId(id)
        .setName(request.getName())
        .setDescription(request.getDescription())
        .setMemberCount(request.getMemberCount())
        .setStatusHistory(StatusFactory.create(StatusHistoryTypes.BOTH))
        .createTeam();
  }
}
