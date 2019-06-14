package fi.joufa.domain.model;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;

import static org.junit.Assert.*;

public class TeamTest {

    @Test
    public void team_shouldInitialize() {
        final Team team = new TeamBuilder()
                .setName("Karhukopla")
                .setMemberCount(3).
                        setDescription("Kiva tiimi")
                .setTeamId(Long.valueOf(1))
                        .setCreatedAt(LocalDateTime.now())
                .setUpdatedAt(LocalDateTime.now())
                        .createTeam();
        assertEquals("Karhukopla", team.getName());
    }

}