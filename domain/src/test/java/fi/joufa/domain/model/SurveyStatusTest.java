package fi.joufa.domain.model;

import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class SurveyStatusTest {

    private SurveyStatus sut;

    @Test
    public void surveyStatus_newStatus_creates() {
        sut = SurveyStatus.createInitial();
        assertNotNull(sut);
        assertTrue(sut.isDraft());
        assertFalse(sut.isOpen());
    }

    @Test
    public void surveyStatus_openClose_opensSurvey() {
        sut = new SurveyStatus(LocalDateTime.now(), null);
        assertNotNull(sut);
        assertFalse(sut.isDraft());
        assertTrue(sut.isOpen());

    }

    @Test
    public void surveyStatus_openClose_reOpen() {
        sut = new SurveyStatus(LocalDateTime.now(), LocalDateTime.now());
        assertNotNull(sut);
        assertFalse(sut.isDraft());

        assertFalse(sut.isOpen());

        sut = sut.open();

        assertTrue(sut.isOpen());


    }

}