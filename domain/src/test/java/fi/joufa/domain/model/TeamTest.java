package fi.joufa.domain.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class TeamTest {

    @Test
    public void team_shouldInitialize() {
        final Team team = new TeamBuilder().setName("Karhukopla").setMemberCount(3).setDescription("Kiva tiimi").createTeam();
    }

}