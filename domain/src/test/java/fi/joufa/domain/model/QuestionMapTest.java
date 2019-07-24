package fi.joufa.domain.model;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class QuestionMapTest {

    @Test
    public void questionMapTest() {
        List<Question> questions = Arrays.asList(new Question("Moro"), new Question("Moro1"));
        final QuestionMap<Question> sut = QuestionMap.createQuestionMap(questions);
        assertNotNull(sut);
        final List<Question> values = sut.getAsList();
        assertEquals(new Question("Moro"), values.get(0));
    }
}