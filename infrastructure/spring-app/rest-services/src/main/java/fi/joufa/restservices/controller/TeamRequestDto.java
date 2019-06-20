package fi.joufa.restservices.controller;

import java.util.Date;

public class TeamRequestDto {
  private Long teamId;
  private String name;
  private Integer memberCount;
  private String description;
  private Date createdAt;
  private Date updatedAt;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getMemberCount() {
    return memberCount;
  }

  public void setMemberCount(Integer memberCount) {
    this.memberCount = memberCount;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Long getTeamId() {
    return teamId;
  }

  public void setTeamId(Long teamId) {
    this.teamId = teamId;
  }

  public Date getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  public Date getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(Date updatedAt) {
    this.updatedAt = updatedAt;
  }

  @Override
  public String toString() {
    return "TeamRequestDto{"
        + "teamId="
        + teamId
        + ", name='"
        + name
        + '\''
        + ", memberCount="
        + memberCount
        + ", description='"
        + description
        + '\''
        + '}';
  }
}
