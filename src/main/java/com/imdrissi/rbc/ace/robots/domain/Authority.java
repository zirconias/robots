package com.imdrissi.rbc.ace.robots.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "AUTHORITY")
public class Authority extends BaseEntity implements GrantedAuthority {

  @Id
  @Column(name = "ID")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;


  public Authority() {
    super();
  }

  public Authority(String name) {
    this.name = name;
  }

  @ManyToMany(mappedBy = "authorities", fetch = FetchType.LAZY)
  private List<User> users;


  @Override
  public String getAuthority() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @JsonIgnore
  public String getName() {
    return name;
  }

  @JsonIgnore
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public List<User> getUsers() {
    return users;
  }

  public void setUsers(List<User> users) {
    this.users = users;
  }
}
