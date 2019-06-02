package fi.joufa.domain.model;

public class Team {
    private final Long teamId;
    private final String name;
    private final Integer memberCount;
    private final String description;

    public Team(Long teamId, String name, Integer memberCount, String description) {
        this.teamId = teamId;
        this.name = name;
        this.memberCount = memberCount;
        this.description = description;
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


    @Override
    public String toString() {
        return "Team{" +
                "teamId=" + teamId +
                ", name='" + name + '\'' +
                ", memberCount=" + memberCount +
                ", description='" + description + '\'' +
                '}';
    }
}
