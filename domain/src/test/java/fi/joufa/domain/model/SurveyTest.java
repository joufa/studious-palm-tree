package fi.joufa.domain.model;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class SurveyTest {

    private static final String NAME = "Test";
    Survey survey;

    @Test
    public void survey_CanBeCreated() {
        survey = SurveyFactory.createNew(NAME);
        assertNotNull(survey);
    }

}
