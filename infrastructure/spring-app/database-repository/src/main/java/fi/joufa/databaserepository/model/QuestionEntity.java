package fi.joufa.databaserepository.model;

import java.util.Objects;
import javax.persistence.*;

@Entity
@Table(name = "questions")
public class QuestionEntity implements Comparable<QuestionEntity> {

  @Id @GeneratedValue private Long id;

  @Column private String text;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "set_id")
  private QuestionSetEntity set;

  @Column private Integer ordering;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public QuestionSetEntity getSet() {
    return set;
  }

  public void setSet(QuestionSetEntity set) {
    this.set = set;
  }

  public Integer getOrdering() {
    return ordering;
  }

  public void setOrdering(Integer ordering) {
    this.ordering = ordering;
  }

  @Override
  public int compareTo(QuestionEntity questionEntity) {
    if (questionEntity.getOrdering() > this.getOrdering()) {
      return 1;
    } else if (questionEntity.getOrdering() < this.getOrdering()) {
      return -1;
    }
    return 0;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    QuestionEntity that = (QuestionEntity) o;
    return Objects.equals(id, that.id)
        && Objects.equals(text, that.text)
        && Objects.equals(set, that.set)
        && Objects.equals(ordering, that.ordering);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, text, set, ordering);
  }
}
