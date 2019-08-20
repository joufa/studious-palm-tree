package fi.joufa.domain.model;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class SurveyTest {

    private static final String NAME = "Test";
    private Survey survey;

    @Test
    public void survey_CanBeCreated() {
        survey = SurveyFactory.createNew(NAME);
        assertNotNull(survey);
    }

    @Test
    public void survey_can_be_opened() {
        survey = SurveyFactory.createNew(NAME);
        assertNotNull(survey);
        System.out.println(survey.isOpen());
        survey.open();
        System.out.println(survey.getStatus());
        survey.close();
        System.out.println(survey.getStatus());
        System.out.println(survey.getSurveyHistory());
    }

}
