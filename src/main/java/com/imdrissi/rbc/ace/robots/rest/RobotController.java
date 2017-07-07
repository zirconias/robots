package com.imdrissi.rbc.ace.robots.rest;

import com.imdrissi.rbc.ace.robots.domain.Robot;
import com.imdrissi.rbc.ace.robots.service.RobotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/robot", produces = MediaType.APPLICATION_JSON_VALUE)
public class RobotController {

  @Autowired
  RobotService robotService;

  @GetMapping("/test")
  ResponseEntity<String> test() {
    return new ResponseEntity<String>("{\"test\":\"ok it works!\"}", HttpStatus.OK);
  }

  @GetMapping
  ResponseEntity<Iterable<Robot>> robots() {
    return ResponseEntity.ok(robotService.allRobots());
  }

}
