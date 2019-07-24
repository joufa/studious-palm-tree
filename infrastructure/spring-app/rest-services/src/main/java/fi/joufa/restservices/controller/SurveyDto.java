package fi.joufa.restservices.controller;

public class SurveyDto {
  private Long id;
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
    return "SurveyDto{" + "id=" + id + ", name='" + name + '\'' + '}';
  }
}
