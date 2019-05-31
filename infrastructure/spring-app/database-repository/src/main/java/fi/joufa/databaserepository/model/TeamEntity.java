
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

  @Override
  public String toString() {
    return "Team{" + "id=" + id + ", name='" + name + '\'' + '}';
  }
}
