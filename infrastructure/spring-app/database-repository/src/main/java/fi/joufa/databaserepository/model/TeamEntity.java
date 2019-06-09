package fi.joufa.databaserepository.model;

import javax.persistence.*;

@Entity
@Table(name = "team")
public class TeamEntity {

  @Id
  @Column(name = "team_id")
  @GeneratedValue
  private Long id;

  @Column(unique = true)
  private String name;

  @Column private Integer memberCount;

  @Column private String description;

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
}
