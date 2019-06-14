package fi.joufa.domain.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Team {
    private final Long teamId;
    private final String name;
    private final Integer memberCount;
    private final String description;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;

    public Team(Long teamId, String name, Integer memberCount, String description, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.teamId = teamId;
        this.name = name;
        this.memberCount = memberCount;
        this.description = description;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Team(String name, Integer memberCount, String description) {
        this.name = name;
        this.memberCount = memberCount;
        this.description = description;
        this.teamId = null;
        this.createdAt = null;
        this.updatedAt = null;
    }

    public Long getTeamId() {
        return teamId;
    }

    public String getName() {
        return name;
    }

    public Integer getMemberCount() {
        return memberCount;
    }

    public String getDescription() {
        return description;
    }


    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    @Override
    public String toString() {
        return "Team{" +
                "teamId=" + teamId +
                ", name='" + name + '\'' +
                ", memberCount=" + memberCount +
                ", description='" + description + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return Objects.equals(name, team.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name);
    }
}
