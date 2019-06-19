package fi.joufa.domain.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SurveyTest {

    private Team testTeam1;

    @Before
    public void init() {
        final StatusHistory sh = StatusFactory.create(StatusHistoryTypes.BOTH);
        testTeam1 = new TeamBuilder().setName("Testitiimi").setMemberCount(3).setStatusHistory(sh).createTeam();
    }
    @Test
    public void surveyCanBeCreated() {
        final Survey survey = new Survey(testTeam1);
        assertNotNull(survey);
    }

    @Test(expected = IllegalArgumentException.class)
    public void surveyCannotBeCreatedWitNull() {
        final Survey survey = new Survey(null);
    }

}