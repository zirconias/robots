package com.imdrissi.rbc.ace.robots.service;

import com.imdrissi.rbc.ace.robots.domain.User;
import com.imdrissi.rbc.ace.robots.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("userDetailsService")
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

  private static final Logger log = LoggerFactory.getLogger(UserDetailsService.class);

  @Autowired
  UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Optional<User> user = userRepository.findByUsername(username);

    if (user.isPresent()) {
      log.debug("user found " + username);
      return user.get();
    } else {
      log.error("user not found with username " + username);
      return new User(username, "");
    }
  }
}
