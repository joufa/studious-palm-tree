package fi.joufa.agilesurvey.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.util.Date;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity {

  @Column private Date updated;

  @Column private Date created;

  @PreUpdate
  protected void onUpdate() {
    updated = new Date();
  }

  @PrePersist
  protected void onPersist() {
    created = new Date();
  }
}
