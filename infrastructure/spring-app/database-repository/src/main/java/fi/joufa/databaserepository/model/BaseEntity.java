package fi.joufa.databaserepository.model;

import java.util.Date;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

public abstract class BaseEntity {

  @UpdateTimestamp private Date updated;

  @CreationTimestamp private Date created;
}

