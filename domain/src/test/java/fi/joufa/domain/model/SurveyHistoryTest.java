package fi.joufa.domain.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class SurveyHistoryTest {

    @Test
    public void history_canBeCreated() {
        SurveyHistory history = new SurveyHistory();
        assertNotNull(history);
    }
}