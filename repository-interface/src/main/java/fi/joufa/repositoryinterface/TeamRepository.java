package fi.joufa.repositoryinterface;

import fi.joufa.domain.model.Team;
import java.util.List;

public interface TeamRepository {
    Team findTeamById(Long teamId);
    Team findTeamByName(String name);
    List<Team> findAll();
    Team createTeam(Team team);
    Team updateTeam(Team team);
    Team deleteTeam(Team team);
 }
