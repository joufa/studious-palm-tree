package fi.joufa.databaserepository.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class QuestionEntity {

  @Id @GeneratedValue private Long id;

  @Column private String text;
}
