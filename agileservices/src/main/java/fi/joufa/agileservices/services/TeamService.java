package fi.joufa.agileservices.services;

import fi.joufa.agileservices.exceptions.AgileException;
import fi.joufa.domain.model.Team;

import java.util.List;
import java.util.Optional;

public interface TeamService {
    Team createTeam(Team team) throws AgileException;
    Team editTeam(Team team) throws AgileException;
    Team deleteTeam(Long teamId) throws AgileException;
    Optional<Team> findTeamById(Long teamId);
    List<Team> findAll();
}
