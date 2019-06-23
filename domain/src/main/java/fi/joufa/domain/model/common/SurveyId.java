package fi.joufa.domain.model.common;

import java.util.Objects;

public class SurveyId {
    private final Long id;

    public SurveyId(Long id) {
        this.id = id;
    }

    public Long get() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SurveyId surveyId = (SurveyId) o;
        return Objects.equals(id, surveyId.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
