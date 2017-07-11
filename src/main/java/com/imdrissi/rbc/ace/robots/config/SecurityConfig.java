package com.imdrissi.rbc.ace.robots.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.AuthenticationEntryPoint;

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

  @Autowired
  private AuthenticationEntryPoint authEntryPoint;

  @Override
  public void configure(final HttpSecurity http) throws Exception {
    http.httpBasic()
      .authenticationEntryPoint(authEntryPoint)
      .and().csrf().disable();

    http.authorizeRequests().antMatchers(HttpMethod.GET, "/", "/**/*.html", "/**/*.{png,jpg,jpeg,svg.ico}", "/**/*.css", "/**/*.js").permitAll();
    http.authorizeRequests().antMatchers(HttpMethod.GET, "/robot").permitAll();
    http.authorizeRequests().antMatchers(
      "/swagger-ui.html", "/swagger-resources", "/swagger-resources/configuration/ui", "/swagger-resources/configuration/security",
      "/v2/api-docs", "/webjars/**").permitAll();
    http.authorizeRequests().antMatchers(HttpMethod.OPTIONS, "/**").permitAll();

    http.authorizeRequests().anyRequest().authenticated();

    http.headers().frameOptions().disable();
  }
}
