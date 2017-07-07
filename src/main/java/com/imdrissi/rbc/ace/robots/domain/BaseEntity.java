package com.imdrissi.rbc.ace.robots.domain;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
public class BaseEntity {

  @Temporal(TemporalType.TIMESTAMP)
  protected Date creationTime;
  @Temporal(TemporalType.TIMESTAMP)
  protected Date modificationTime;

  protected Boolean deleted;

  public Date getCreationTime() {
    return creationTime;
  }

  public void setCreationTime(Date creationTime) {
    this.creationTime = creationTime;
  }

  public Date getModificationTime() {
    return modificationTime;
  }

  public void setModificationTime(Date modificationTime) {
    this.modificationTime = modificationTime;
  }

  public Boolean getDeleted() {
    return deleted;
  }

  public void setDeleted(Boolean deleted) {
    this.deleted = deleted;
  }

  @PrePersist
  public void prePersist() {
    creationTime = new Date();
  }

  @PreUpdate
  public void preUpdate() {
    modificationTime = new Date();
  }
}
