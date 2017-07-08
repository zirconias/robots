package com.imdrissi.rbc.ace.robots.service;


import com.imdrissi.rbc.ace.robots.domain.Authority;
import com.imdrissi.rbc.ace.robots.domain.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class CustomUserPrincipal implements UserDetails {

  private User user;

  public CustomUserPrincipal(User user) {
    this.user = user;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
    authorities = user.getAuthorities().stream()
      .map(authority -> new SimpleGrantedAuthority(((Authority) authority).getName()))
      .collect(Collectors.toList());
    return authorities;
  }

  @Override
  public String getUsername() {
    return user.getUsername();
  }


  @Override
  public String getPassword() {
    return user.getPassword();
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }

}
