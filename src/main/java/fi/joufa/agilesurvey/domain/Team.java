package fi.joufa.agilesurvey.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
@Getter
@Setter
public class Team extends BaseEntity {

  @Id
  @Column(name = "team_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(unique = true)
  private String name;

  @Override
  public String toString() {
    return "Team{" + "id=" + id + ", name=" + name + '}';
  }
}
