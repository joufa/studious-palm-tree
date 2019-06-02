package fi.joufa.databaserepository.model;

import javax.persistence.*;

@Entity
@Table
public class TeamEntity extends BaseEntity {

  @Id
  @Column(name = "team_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(unique = true)
  private String name;

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

  @Override
  public String toString() {
    return "Team{" + "id=" + id + ", name='" + name + '\'' + '}';
  }
}
