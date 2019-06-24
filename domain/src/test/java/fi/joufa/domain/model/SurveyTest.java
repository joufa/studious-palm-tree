package fi.joufa.domain.model;

import fi.joufa.domain.model.common.TeamId;
import org.junit.Test;

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

    @Test(expected = IllegalArgumentException.class)
    public void survey_addQuestionSet_canBeAddedOnce() {
        survey = SurveyFactory.createNew(NAME);
        final QuestionSet qs = QuestionSet.create(null, "Setti");
        qs.addQuestion(1, new Question("fish?"));
        qs.addQuestion(2, new Question("more fish?"));
        survey.addQuestionSet(1, qs);
        survey.addQuestionSet(1, qs);
    }

    @Test(expected = IllegalStateException.class)
    public void survey_update_cannotUpdateClosed() {
        survey = SurveyFactory.createNew(NAME);
        final QuestionSet qs = QuestionSet.create(null, "Setti");
        qs.addQuestion(1, new Question("fish?"));
        qs.addQuestion(2, new Question("more fish?"));
        survey.addQuestionSet(1, qs);
        survey.close();
        survey.addQuestionSet(1, qs);

    }

    @Test
    public void survey_open_SurveyCanBeOpened() {
        survey = SurveyFactory.createNew(NAME);
        final QuestionSet qs = QuestionSet.create(null, "Setti");
        qs.addQuestion(1, new Question("fish?"));
        qs.addQuestion(2, new Question("more fish?"));
        survey.addQuestionSet(1, qs);
        survey.addTeam(new TeamId(Long.valueOf(1)));
        survey.open();
        assertTrue(survey.isOpen());
        survey.close();
        assertFalse(survey.isOpen());
    }

    @Test
    public void survey_clone_surveyCanBeCloned() {
        survey = SurveyFactory.createNew(NAME);
        final QuestionSet qs = QuestionSet.create(null, "Setti");
        qs.addQuestion(1, new Question("fish?"));
        qs.addQuestion(2, new Question("more fish?"));
        survey.addQuestionSet(1, qs);
        survey.addTeam(new TeamId(Long.valueOf(1)));
        survey.open();
        survey.close();

        final Survey cloned = SurveyFactory.clone(survey);
        assertNotEquals(cloned, survey);
    }
}
