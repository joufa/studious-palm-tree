package fi.joufa.domain.model.common;

import java.util.Objects;

public class QuestionSetId {
    private final Long id;

    public QuestionSetId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuestionSetId that = (QuestionSetId) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
