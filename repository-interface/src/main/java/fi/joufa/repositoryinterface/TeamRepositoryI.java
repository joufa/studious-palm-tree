package fi.joufa.repositoryinterface;

import fi.joufa.domain.model.Team;
import fi.joufa.domain.model.common.TeamId;

import java.util.List;

public interface TeamRepositoryI {
    Team findTeamByName(String name);
    Team findTeamById(TeamId id);
    List<Team> findAll();
    Team createTeam(Team team);
    Team updateTeam(Team team);
    Team deleteTeam(Team team);
 }
