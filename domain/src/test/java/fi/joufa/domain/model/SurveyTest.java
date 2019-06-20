package fi.joufa.domain.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SurveyTest {

    private Team testTeam1;

    @Before
    public void init() {
        final StatusHistory sh = StatusFactory.createHistory();
        testTeam1 = new TeamBuilder().setName("Testitiimi").setMemberCount(3).setStatusHistory(sh).createTeam();
    }
    @Test
    public void surveyCanBeCreated() {
        final Survey survey = new Survey();
        assertNotNull(survey);
    }

}