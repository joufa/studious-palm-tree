package fi.joufa.domain.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class QuestionTest {

    @Test
    public void question_createNew_questionIsCreated() {

        final String text = "How much is the fish?";
        final String secondText = "How much is the fish?";
        final String thirdText = "What's the time?";

        final Question question1 = new Question(text);
        final Question question2 = new Question(secondText);
        final Question question3 = new Question(thirdText);
        assertEquals(text, question1.getQuestion());
        assertEquals(question1, question2);
        assertEquals(thirdText, question3.getQuestion());
        assertNotEquals(question1, question3);
        assertNotEquals(question2, "TestString");

    }

}