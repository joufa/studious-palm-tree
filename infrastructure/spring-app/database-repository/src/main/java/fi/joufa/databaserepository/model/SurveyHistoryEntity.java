package fi.joufa.databaserepository.model;

import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "survey_history")
public class SurveyHistoryEntity {

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "survey_id")
  private SurveyEntity survey;

  @Id private String id;

  @Column private Date openedOn;

  @Column private Date closedOn;

  public SurveyHistoryEntity() {};

  public SurveyHistoryEntity(String id, Date openedOn, Date closedOn) {
    this.id = id;
    this.openedOn = openedOn;
    this.closedOn = closedOn;
  }

  public SurveyEntity getSurvey() {
    return survey;
  }

  public void setSurvey(SurveyEntity survey) {
    this.survey = survey;
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

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }
}
