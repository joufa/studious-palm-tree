package fi.joufa.domain.model;

import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class SurveyStatusTest {

    private SurveyStatus sut;

    @Test
    public void surveyStatus_can_be_created() {
        sut = SurveyStatus.createInitial();
        assertNotNull(sut);
        assertTrue(sut.isDraft());
        assertFalse(sut.isOpen());
        assertNull(sut.getId());
    }

    @Test
    public void surveyStatus_can_be_opened() {
        sut = SurveyStatus.createInitial();

        sut.open();

        assertTrue(sut.isOpen());
        assertFalse(sut.isDraft());
        assertNotNull(sut.getId());

        // Aggregate root should archive
        // Further modifications disabled
        final SurveyStatus closed = sut.close();

        assertNotNull(closed.getClosedOn());
        assertNotNull(closed.getOpenedOn());
        assertNotNull(closed.getId());

    }

}