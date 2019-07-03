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
        final QuestionMap<Question> qm = QuestionMap.createQuestionMap(this.questions);
        final QuestionSet qs = QuestionSet.create("Setti 1", qm);
        assertNotNull(qs);
        assertTrue(qs.getQuestionMap().getQuestions().containsKey(1));
        assertEquals(this.questions.get(0), qs.getQuestionMap().getByKey(1));
        assertEquals(this.questions.get(1), qs.getQuestionMap().getByKey(2));
        assertEquals(this.questions.get(2), qs.getQuestionMap().getByKey(3));
    }

}