package fi.joufa.agilesurvey.domain;

import java.util.Set;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

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
