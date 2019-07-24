package fi.joufa.databaserepository.model;

import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "surveys")
public class SurveyEntity {
  @Id
  @GeneratedValue
  @Column(name = "id", updatable = false, nullable = false)
  private Long id;

  @Column(unique = true)
  private String name;

  @OneToMany(mappedBy = "survey")
  private List<QuestionSetEntity> sets;

  @Column private Date createdAt;

  @Column private Date updatedAt;

  @Column private Date openedOn;

  @Column private Date closedOn;

  @ElementCollection
  @CollectionTable(name = "survey_teams")
  private Set<Long> teams;

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

  public List<QuestionSetEntity> getSets() {
    return sets;
  }

  public void setSets(List<QuestionSetEntity> sets) {
    this.sets = sets;
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

  public Date getOpenedOn() {
    return openedOn;
  }

  public void setOpenedOn(Date openedOn) {
    this.openedOn = openedOn;
  }

  public Date getClosedOn() {
    return closedOn;
  }

  public void setClosedOn(Date closedOn) {
    this.closedOn = closedOn;
  }

  public Set<Long> getTeams() {
    return teams;
  }

  public void setTeams(Set<Long> teams) {
    this.teams = teams;
  }
}
