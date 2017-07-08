package com.imdrissi.rbc.ace.robots.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

//  @Value("${spring.h2.console.path}")
//  private String H2_CONSOLE;
//
//  @Override
//  protected void configure(HttpSecurity httpSecurity) throws Exception {
//    httpSecurity.csrf().disable();
//    httpSecurity.headers().frameOptions().disable();//for h2 console
//
//    httpSecurity.authorizeRequests().antMatchers(H2_CONSOLE).permitAll();
//  }


  @Override
  public void configure(final HttpSecurity http) throws Exception {
    http.httpBasic().and()
      .csrf().disable();
    http.authorizeRequests().anyRequest().authenticated();

    http.headers().frameOptions().disable();
  }
}
