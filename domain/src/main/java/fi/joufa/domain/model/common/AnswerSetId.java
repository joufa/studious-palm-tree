package fi.joufa.domain.model.common;

import java.util.Objects;

public class AnswerSetId {
    private Long id;

    public AnswerSetId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnswerSetId that = (AnswerSetId) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "AnswerSetId{" +
                "id=" + id +
                '}';
    }
}
