package fi.joufa.domain.model;

import java.util.Objects;


public class QuestionSet implements Answerable {

    private final String name;
    private final QuestionMap<Question> questionMap;

    private QuestionSet(String name, QuestionMap<Question> questionMap) {
        this.name = name;
        this.questionMap = questionMap;
    }

    public boolean isEmpty() {
        return this.questionMap.isEmpty();
    }


    public static QuestionSet create(String name, QuestionMap<Question> questions) {
        if (name == null || questions == null || questions.isEmpty()) {
            throw new IllegalArgumentException("Empty arguments for QuestionSet");
        }
        return new QuestionSet(name, questions);
    }

    public String getName() {
        return name;
    }

    public QuestionMap<Question> getQuestionMap() {
        return questionMap;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuestionSet that = (QuestionSet) o;
        return name.equals(that.name) &&
                questionMap.equals(that.questionMap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, questionMap);
    }

    @Override
    public String toString() {
        return "QuestionSet{" +
                "name='" + name + '\'' +
                ", questionMap=" + questionMap +
                '}';
    }
}
