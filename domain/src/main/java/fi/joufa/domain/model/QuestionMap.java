package fi.joufa.domain.model;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * QuestionMap encapsulates the order of questionsets
 * or questions
 *
 * @param <T>
 */
public class QuestionMap<T extends Answerable> {
    private Map<Integer, T> questions;

    private QuestionMap(Map<Integer, T> questions) {
        this.questions = questions;
    }


    public static <T extends Answerable> QuestionMap<T> createQuestionMap(List<T> questions) {
        final Map<Integer, T> orderedQuestions = new HashMap<>();
        AtomicInteger counter = new AtomicInteger(0);
        questions.stream().forEach(answerable ->
            orderedQuestions.put(counter.incrementAndGet(), answerable)
        );
        return new QuestionMap<>(orderedQuestions);
    }

    public Map<Integer, T> getQuestions() {
        return questions;
    }

    public T getByKey(Integer key) {
        return this.questions.get(key);
    }

    public boolean isEmpty() {
        return this.questions.isEmpty();
    }

    public List<T> getAsList() {
        if (this.questions == null) {
            return Collections.emptyList();
        }

        return new ArrayList<>(this.questions.values());
    }

    @Override
    public String toString() {
        return "QuestionMap{" +
                "questions=" + questions +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuestionMap<?> that = (QuestionMap<?>) o;
        return questions.equals(that.questions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(questions);
    }

    public int size() {
        if (this.questions == null) {
            return 0;
        }
        return this.questions.size();
    }
}
