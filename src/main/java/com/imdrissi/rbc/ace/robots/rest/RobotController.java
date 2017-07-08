package com.imdrissi.rbc.ace.robots.rest;

import com.imdrissi.rbc.ace.robots.domain.Robot;
import com.imdrissi.rbc.ace.robots.service.RobotService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@Api(basePath = "/robot", value = "Robot", description = "Robot operations", produces = "application/json")
@RestController
@RequestMapping(value = "/robot", produces = MediaType.APPLICATION_JSON_VALUE)
public class RobotController {

  @Autowired
  RobotService robotService;

  @ApiOperation(value = "test endpoint", notes = "check if endpoint is working")
  @PreAuthorize("hasAnyAuthority('ADMIN','MANAGER','USER')")
  @GetMapping("/test")
  ResponseEntity<String> test(Principal principal) {
    return new ResponseEntity<String>("{\"test\":\"ok it works!\"}", HttpStatus.OK);
  }

  @ApiOperation(value = "get All Robots", notes = "returns a list of robots")
  @GetMapping
  ResponseEntity<Iterable<Robot>> robots() {
    return ResponseEntity.ok(robotService.allRobots());
  }

}
