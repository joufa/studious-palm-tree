package fi.joufa.domain.model;

import java.time.LocalDateTime;

public class TeamBuilder {
    private Long teamId;
    private String name;
    private Integer memberCount;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public TeamBuilder setTeamId(Long teamId) {
        this.teamId = teamId;
        return this;
    }

    public TeamBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public TeamBuilder setMemberCount(Integer memberCount) {
        this.memberCount = memberCount;
        return this;
    }

    public TeamBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    public TeamBuilder setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public TeamBuilder setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public Team createTeam() {
        return new Team(teamId, name, memberCount, description, createdAt, updatedAt);
    }
}