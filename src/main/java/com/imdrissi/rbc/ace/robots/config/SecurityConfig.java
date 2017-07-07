package com.imdrissi.rbc.ace.robots.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Value("${spring.h2.console.path}")
  private String H2_CONSOLE;

  @Override
  protected void configure(HttpSecurity httpSecurity) throws Exception {
    httpSecurity.csrf().disable();
    httpSecurity.headers().frameOptions().disable();//for h2 console

    httpSecurity.authorizeRequests().antMatchers(H2_CONSOLE).permitAll();
  }

}
