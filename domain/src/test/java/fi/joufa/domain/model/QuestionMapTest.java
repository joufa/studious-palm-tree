package fi.joufa.domain.model;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class QuestionMapTest {

    @Test
    public void questionMapTest() {
        List<Question> questions = Arrays.asList(new Question("Moro"), new Question("Moro1"));
        final QuestionMap sut = QuestionMap.createQuestionMap(questions);
        System.out.println(sut);
    }
}