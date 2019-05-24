package fi.joufa.agilesurvey.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
@Getter
@Setter
public class Survey extends BaseEntity {

  @Id
  @Column(name = "survey_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinTable(
      name = "surveyPart_survey",
      joinColumns = {@JoinColumn(name = "surveyPart_id")})
  private Set<SurveyPart> parts;
}
