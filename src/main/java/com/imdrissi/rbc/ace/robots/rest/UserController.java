package com.imdrissi.rbc.ace.robots.rest;

import com.imdrissi.rbc.ace.robots.service.CustomUserPrincipal;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Api(basePath = "/auth", value = "current user", description = "auth operations", produces = "application/json")
@CrossOrigin
@RestController
@RequestMapping(value = "/auth", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

  @ApiOperation(value = "Returns current user", notes = "return current authenticated user")
  @GetMapping("/user")
  public CustomUserPrincipal user(@AuthenticationPrincipal CustomUserPrincipal user) {
    return user;
  }

  @ApiOperation(value = "Returns current principal", notes = "return current authenticated Principal")
  @GetMapping("/principal")
  public Principal user(Principal user) {
    return user;
  }

  @ApiOperation(value = "Log out current user")
  @PostMapping("/logout")
  public ResponseEntity<String> logout() {
    SecurityContextHolder.getContext().getAuthentication().setAuthenticated(false);
    return new ResponseEntity<String>("{\"logout\":\"logged out!\"}", HttpStatus.OK);
  }

}
