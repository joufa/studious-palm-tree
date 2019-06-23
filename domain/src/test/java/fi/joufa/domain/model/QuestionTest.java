package fi.joufa.domain.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class QuestionTest {

    @Test
    public void question_createNew_questionIsCreated() {

        final String text = "How much is the fish?";
        final Question question = new Question(text);
        assertEquals(text, question.getQuestion());
    }

}