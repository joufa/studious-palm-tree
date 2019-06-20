package fi.joufa.domain.model;


import fi.joufa.domain.model.common.TeamId;

public class TeamBuilder {
    private TeamId teamId;
    private String name;
    private Integer memberCount;
    private String description;
    private StatusHistory statusHistory;

    public TeamBuilder setTeamId(TeamId teamId) {
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

    public TeamBuilder setStatusHistory(StatusHistory statusHistory) {
        this.statusHistory = statusHistory;
        return this;
    }

    public Team createTeam() {
        return new Team(teamId, name, memberCount, description, statusHistory);
    }
}