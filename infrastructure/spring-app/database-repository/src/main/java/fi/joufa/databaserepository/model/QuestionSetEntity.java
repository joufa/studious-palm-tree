package fi.joufa.databaserepository.model;

import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "questionsets")
public class QuestionSetEntity implements Comparable<QuestionSetEntity> {
  @Id @GeneratedValue private Long id;

  @Column private String name;

  @Column private Integer ordering;

  @OneToMany(mappedBy = "set")
  private List<QuestionEntity> questions;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "survey_id")
  private SurveyEntity survey;

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

  public Integer getOrdering() {
    return ordering;
  }

  public void setOrdering(Integer ordering) {
    this.ordering = ordering;
  }

  public SurveyEntity getSurvey() {
    return survey;
  }

  public void setSurvey(SurveyEntity survey) {
    this.survey = survey;
  }

  public List<QuestionEntity> getQuestions() {
    return questions;
  }

  public void setQuestions(List<QuestionEntity> questions) {
    this.questions = questions;
  }

  @Override
  public int compareTo(QuestionSetEntity questionEntity) {
    if (questionEntity.getOrdering() > this.getOrdering()) {
      return 1;
    } else if (questionEntity.getOrdering() < this.getOrdering()) {
      return -1;
    }
    return 0;
  }
}
