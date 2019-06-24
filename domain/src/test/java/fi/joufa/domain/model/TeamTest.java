package fi.joufa.domain.model;

import fi.joufa.domain.model.common.TeamId;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;

import static org.junit.Assert.*;

public class TeamTest {

    @Test
    public void team_equality() {
        final Team firstTeam = new TeamBuilder().setTeamId(new TeamId(Long.valueOf(1))).setName("Mulq").setMemberCount(3).createTeam();
        final Team secondTeam = new TeamBuilder().setTeamId(new TeamId(Long.valueOf(1))).setName("Dest").setMemberCount(3).createTeam();
        final Team thirdTeam = new TeamBuilder().setTeamId(new TeamId(Long.valueOf(2))).setName("Test").setMemberCount(3).createTeam();
        final Team fourthTeam = new TeamBuilder().setTeamId(new TeamId(Long.valueOf(3))).setName("Mulq").setMemberCount(3).createTeam();

        assertNotEquals(firstTeam, secondTeam);
        assertNotEquals(firstTeam, thirdTeam);
        assertEquals(firstTeam, firstTeam);
        assertNotEquals(firstTeam, fourthTeam);
    }

    @Test
    public void team_createTeam_buildsCorrectly() {
        final Team firstTeam = new TeamBuilder()
                .setTeamId(new TeamId(Long.valueOf(1)))
                .setName("Mulq")
                .setMemberCount(3)
                .setDescription("Kuvausta")
                .setStatusHistory(StatusFactory.createHistory())
                .createTeam();

        assertEquals(new TeamId(Long.valueOf(1)), firstTeam.getTeamId());
        assertEquals("Mulq", firstTeam.getName());
        assertEquals(Integer.valueOf(3), firstTeam.getMemberCount());
        assertEquals("Kuvausta", firstTeam.getDescription());
        assertNotNull(firstTeam.getStatusHistory());


    }

}