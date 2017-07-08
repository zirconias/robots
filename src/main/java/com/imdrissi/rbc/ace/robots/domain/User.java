package com.imdrissi.rbc.ace.robots.domain;


import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "USER")
public class User extends BaseEntity {

  @Id
  @Column(name = "ID")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long userId;

  @NotNull
  private String username;

  @NotNull
  private String password;

  private boolean enabled = true;


  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(
    name = "USER_AUTHORITY",
    joinColumns = {@JoinColumn(name = "USER_ID", referencedColumnName = "ID")},
    inverseJoinColumns = {@JoinColumn(name = "AUTHORITY_ID", referencedColumnName = "ID")})
  private List<Authority> authorities;

  public User() {
    super();
  }

  public User(String username, String password) {
    this.username = username;
    this.password = password;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }


  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public Collection<? extends GrantedAuthority> getAuthorities() {
    //Set<GrantedAuthority> authorities = new HashSet<>();
    return authorities;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public boolean isEnabled() {
    return true;
  }

  public void setEnabled(boolean enabled) {
    this.enabled = enabled;
  }

  public boolean isAccountNonExpired() {
    return true;
  }

  public boolean isAccountNonLocked() {
    return true;
  }

  public boolean isCredentialsNonExpired() {
    return true;
  }

  public void setAuthorities(List<Authority> authorities) {
    this.authorities = authorities;
  }
}
