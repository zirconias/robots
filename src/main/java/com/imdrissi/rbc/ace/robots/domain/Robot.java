package com.imdrissi.rbc.ace.robots.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "ROBOT")
public class Robot extends BaseEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Version
  @JsonIgnore
  private Integer version;

  private String robotId;
  private String description;
  private String imageUrl;
  private BigDecimal price;

  public Robot() {
    super();
  }

  public Robot(String robotId, String description, String imageUrl, BigDecimal price) {
    this.robotId = robotId;
    this.description = description;
    this.imageUrl = imageUrl;
    this.price = price;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Integer getVersion() {
    return version;
  }

  public void setVersion(Integer version) {
    this.version = version;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getRobotId() {
    return robotId;
  }

  public void setRobotId(String robotId) {
    this.robotId = robotId;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }
}
