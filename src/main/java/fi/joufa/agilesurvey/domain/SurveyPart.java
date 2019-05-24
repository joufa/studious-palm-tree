package fi.joufa.agilesurvey.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
@Getter
@Setter
public class SurveyPart extends BaseEntity {

  @Id
  @JoinColumn(name = "surveyPart_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinTable(
      name = "surveyPart_question",
      joinColumns = @JoinColumn(name = "question_id"),
      inverseJoinColumns = @JoinColumn(name = "surveyPart_id"))
  private Set<Question> questions;

  @Column(nullable = false)
  private Integer maxTotalPoints;

  @Column(nullable = false)
  private Integer maxPointsPerQuestion;
}
