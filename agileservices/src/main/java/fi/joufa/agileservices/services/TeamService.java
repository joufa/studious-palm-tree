package fi.joufa.agileservices.services;

import fi.joufa.agileservices.exceptions.AgileException;
import fi.joufa.domain.model.Team;

import java.util.List;
import java.util.Optional;

public interface TeamService {

    /**
     * Creates a new team.
     *
     * @param team
     * @return Team
     * @throws AgileException if team with same name exists.
     */
    Team createTeam(Team team) throws AgileException;

    /**
     * Updates team details.
     *
     * @param team
     * @return Team
     * @throws AgileException if team cannot be found.
     */
    Team editTeam(Team team) throws AgileException;

    /**
     * Deletes a team.
     * @param team
     * @return Deleted team.
     * @throws AgileException If team has surveys or team cannot be found
     */
    Team deleteTeam(Team team) throws AgileException;

    /**
     * Finds an existing team
     *
     * @param team
     * @return
     */
    Optional<Team> findTeamByName(String team);

    /**
     * Finds all teams
     *
     * @return
     */
    List<Team> findAll();
}
