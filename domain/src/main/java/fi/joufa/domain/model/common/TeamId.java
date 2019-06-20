package fi.joufa.domain.model.common;

import java.util.Objects;

public class TeamId {
    private final Long id;

    public TeamId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TeamId teamId = (TeamId) o;
        return Objects.equals(id, teamId.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "TeamId{" +
                "id=" + id +
                '}';
    }
}
