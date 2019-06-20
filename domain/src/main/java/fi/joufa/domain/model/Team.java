package fi.joufa.domain.model;

import fi.joufa.domain.model.common.TeamId;

import java.util.Objects;

public class Team {
    private final TeamId teamId;
    private final String name;
    private final Integer memberCount;
    private final String description;
   private final StatusHistory statusHistory;

    public Team(TeamId teamId, String name, Integer memberCount, String description, StatusHistory statusHistory) {
        this.teamId = teamId;
        this.name = name;
        this.memberCount = memberCount;
        this.description = description;
        this.statusHistory = statusHistory;
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

    public StatusHistory getStatusHistory() {
        return statusHistory;
    }

    public TeamId getTeamId() {
        return teamId;
    }

    @Override
    public String toString() {
        return "Team{" +
                "teamId=" + teamId +
                ", name='" + name + '\'' +
                ", memberCount=" + memberCount +
                ", description='" + description + '\'' +
                ", statusHistory=" + statusHistory +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return Objects.equals(teamId, team.teamId) &&
                Objects.equals(name, team.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
