package fi.joufa.agilesurvey.domain;

import java.util.Date;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
public class Answer {
  @Id
  @Column(name = "answer_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "survey_id")
  private Survey survey;

  @ManyToOne
  @JoinColumn(name = "surveyPart_id")
  private SurveyPart surveyPart;

  @Column(nullable = false)
  private Date answeredDate;

  @Column(nullable = false)
  private Integer score;

  @Column private String comment;

  @Enumerated(EnumType.STRING)
  private Role role;

  @ManyToOne
  @JoinColumn(name = "team_id")
  private Team team;

  @ManyToOne
  @JoinColumn(name = "question_id")
  private Question question;
}
