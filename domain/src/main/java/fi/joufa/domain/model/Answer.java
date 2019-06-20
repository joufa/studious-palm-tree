package fi.joufa.domain.model;

import java.math.BigDecimal;
import java.util.Objects;

public class Answer {

    private Question question;
    private BigDecimal value;
    private String comment;

    public Answer(Question question, BigDecimal value, String comment) {
        this.question = question;
        this.value = value;
        this.comment = comment;
    }

    public Question getQuestion() {
        return question;
    }

    public BigDecimal getValue() {
        return value;
    }

    public String getComment() {
        return comment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Answer answer = (Answer) o;
        return Objects.equals(question, answer.question);
    }

    @Override
    public int hashCode() {

        return Objects.hash(question);
    }
}
