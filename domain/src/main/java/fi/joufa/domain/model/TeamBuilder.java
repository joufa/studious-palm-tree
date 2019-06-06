package fi.joufa.domain.model;

public class TeamBuilder {
    private Long teamId;
    private String name;
    private Integer memberCount;
    private String description;

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

    public Team createTeam() {
        return new Team(teamId, name, memberCount, description);
    }
}