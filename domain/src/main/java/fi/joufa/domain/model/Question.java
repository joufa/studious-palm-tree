package fi.joufa.domain.model;

import java.util.Objects;

/**
 * Question aggregate root
 */
public class Question {

    private String questionName;

    public Question(String questionName) {
        this.questionName = questionName;
    }

    public String getQuestionName() {
        return questionName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question = (Question) o;
        return Objects.equals(questionName, question.questionName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(questionName);
    }

    @Override
    public String toString() {
        return "Question{" +
                "questionName='" + questionName + '\'' +
                '}';
    }
}
