package fi.joufa.domain.model;

import fi.joufa.domain.model.common.TeamId;
import org.junit.Before;
import org.junit.Test;

import java.security.InvalidParameterException;
import java.util.Set;

import static org.junit.Assert.*;

public class SurveyTest {

    private static final String NAME = "Test";
    Survey survey;

    @Test
    public void survey_CanBeCreated() {
        survey = SurveyFactory.createNew(NAME);
        assertNotNull(survey);
    }

    @Test
    public void survey_addTeams_canAddValidTeam() {
        survey = SurveyFactory.createNew(NAME);
        final Team team = new TeamBuilder().setTeamId(new TeamId(Long.valueOf(1))).setName("Testi").createTeam();
        survey.addTeam(team.getTeamId());
        final Set<TeamId> teams = survey.getTeams();
        assertEquals("Team size is 1", 1, teams.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void survey_addTeams_cannotAddEmptyTeamReference() {
        survey = SurveyFactory.createNew(NAME);
        final Team team = new TeamBuilder().setName("Testi").createTeam();
        // Is null
        survey.addTeam(team.getTeamId());
    }

    @Test(expected = IllegalStateException.class)
    public void survey_addTeams_teamCanBeAddedOnlyOnce() {
        final Survey survey = SurveyFactory.createNew(NAME);
        final Team team = new TeamBuilder().setTeamId(new TeamId(Long.valueOf(1))).setName("Testi").createTeam();
        survey.addTeam(team.getTeamId());
        survey.addTeam(team.getTeamId());
    }

    @Test
    public void survey_addQuestionSet_canBeAddedOnce() {
        survey = SurveyFactory.createNew(NAME);
        final QuestionSet qs = QuestionSet.create(null, "Setti");
        qs.addQuestion(1, new Question("fish?"));
        qs.addQuestion(2, new Question("more fish?"));

        survey.addQuestionSet(1, qs);
    }

    @Test
    public void survey_build_returnsValidSurvey() {
        survey = SurveyFactory.createNew(NAME);

    }


}