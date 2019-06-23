package fi.joufa.domain.model;

import fi.joufa.domain.model.common.QuestionSetId;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class QuestionSetTest {

    private List<Question> questions;

    @Before
    public void initTest() {
        final Question q1 = new Question("Kysymys 1");
        final Question q2 = new Question("Kysymys 2");
        final Question q3 = new Question("Kysymys 3");

        this.questions = Arrays.asList(q1, q2, q3);
    }

    @Test
    public void setCanBeCreated() {
        final QuestionSet qs = QuestionSet.create(null, "Initial set");
        assertNotNull(qs);
    }

    @Test
    public void questionCanBeAdded() {
        final QuestionSet qs = QuestionSet.create(
                new QuestionSetId(Long.valueOf(1)),
                "Eka",
                questions.get(0), questions.get(1));
        assertNotNull(qs);
        assertFalse(qs.isEmpty());
    }

    @Test(expected = IllegalStateException.class)
    public void sameQuestionsCannotBeAddedTwice() {
        final QuestionSet qs = QuestionSet.create(
                new QuestionSetId(Long.valueOf(1)),
                "Eka",
                questions.get(0), questions.get(0));
    }


}