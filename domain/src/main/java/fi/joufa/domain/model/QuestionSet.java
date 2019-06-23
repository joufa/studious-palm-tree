package fi.joufa.domain.model;

import fi.joufa.domain.model.common.QuestionSetId;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;


public class QuestionSet {

    private final QuestionSetId questionSetId;
    private final String name;
    private Map<Integer, Question> questionMap;

    private QuestionSet(QuestionSetId questionSetId, String name) {
        this.questionSetId = questionSetId;
        this.name = name;
    }

    protected void addQuestion(Integer position, Question question) {
       if (this.questionMap == null) {
           this.questionMap = new HashMap<>();
       }
       if (questionMap.containsKey(position)) {
           throw new IllegalStateException(String.format("QuestionSet contains a question in position %d", position));
       }
       if (questionMap.containsValue(question)) {
           throw new IllegalStateException(String.format("QuestionSet already has question %s", question.toString()));
       }
       this.questionMap.put(position, question);

    }


    public boolean isEmpty() {
        return this.questionMap == null ||this.questionMap.isEmpty();
    }


    public static QuestionSet create(QuestionSetId id, String name, Question... questions) {
        final AtomicInteger counter = new AtomicInteger();
        final QuestionSet set  = new QuestionSet(id, name);
        for (Question question : questions) {
            set.addQuestion(counter.incrementAndGet(), question);
        }
        return set;
    }
    public static QuestionSet create(QuestionSetId id, String name) {
        return new QuestionSet(id, name);
    }
    protected  boolean isValid() {
        return this.name != null && this.questionMap != null;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuestionSet that = (QuestionSet) o;
        return Objects.equals(questionSetId, that.questionSetId) &&
                Objects.equals(name, that.name) &&
                Objects.equals(questionMap, that.questionMap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(questionSetId, name, questionMap);
    }
}
