package fi.joufa.domain.model;

import java.util.Objects;


public class Question {

    private final String questionText;

    public Question(String questionText) {
        this.questionText = questionText;
    }

    public String getQuestion() {
        return questionText;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question1 = (Question) o;
        return Objects.equals(questionText, question1.questionText);
    }

    @Override
    public int hashCode() {
        return Objects.hash(questionText);
    }

    @Override
    public String toString() {
        return "Question{" +
                "questionText='" + questionText + '\'' +
                '}';
    }

}
