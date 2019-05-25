package fi.joufa.agilesurvey.domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import lombok.Getter;
import lombok.Setter;

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
