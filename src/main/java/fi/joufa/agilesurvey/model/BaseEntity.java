package fi.joufa.agilesurvey.model;

import java.util.Date;
import javax.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity {

  @UpdateTimestamp private Date updated;

  @CreationTimestamp private Date created;
}
