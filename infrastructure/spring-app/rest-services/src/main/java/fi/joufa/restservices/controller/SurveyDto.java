package fi.joufa.restservices.controller;

import java.util.Date;
import java.util.Set;

public class SurveyDto {
  private Long id;
  private String name;
  private Set<Long> teams;
  private Date createdAt;
  private Date updatedAt;

  public Set<Long> getTeams() {
    return teams;
  }

  public void setTeams(Set<Long> teams) {
    this.teams = teams;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
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
    return "SurveyDto{" + "id=" + id + ", name='" + name + '\'' + '}';
  }
}
