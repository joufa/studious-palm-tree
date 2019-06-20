package fi.joufa.domain.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class QuestionSet {

    private String name;
    private Set<Question> questions;

    public QuestionSet(String name) {
        this.name = name;
        this.questions = new HashSet<>();
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public Set<Question> getQuestions() {
        return questions;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuestionSet that = (QuestionSet) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
