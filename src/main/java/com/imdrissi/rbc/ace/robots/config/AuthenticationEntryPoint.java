package com.imdrissi.rbc.ace.robots.config;

import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//todo:[x] modification du header www-authenticate to prevent the popup
@Component
public class AuthenticationEntryPoint implements
  org.springframework.security.web.AuthenticationEntryPoint {


  @Override
  public void commence(HttpServletRequest request, HttpServletResponse response, org.springframework.security.core.AuthenticationException e) throws IOException, ServletException {
//    response.addHeader("WWW-Authenticate", "Basic realm=" + getRealmName());
    response.addHeader("x-Authenticate", "Basic realm=" + getRealmName() + "");
    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
    PrintWriter writer = response.getWriter();
    //writer.println("HTTP Status 401 - " + e.getMessage());
    writer.write("{\"error\":\"" + e.getMessage() + "\"}");
  }

  public String getRealmName() {
    return "ace robot";
  }
}
