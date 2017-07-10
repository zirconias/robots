package com.imdrissi.rbc.ace.robots.rest;

import com.imdrissi.rbc.ace.robots.domain.Robot;
import com.imdrissi.rbc.ace.robots.service.RobotService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@CrossOrigin
@Api(basePath = "/robot", value = "Robot", description = "Robot operations", produces = "application/json")
@RestController
@RequestMapping(value = "/robot", produces = MediaType.APPLICATION_JSON_VALUE)
public class RobotController {

  private static final Logger log = LoggerFactory.getLogger(RobotController.class);

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

  @ApiOperation(value = "Get robot by id", notes = "returns a robot by id")
  @GetMapping("/{robotId}")
  ResponseEntity<Robot> getRobotByRobotId(@PathVariable String robotId) {
    Robot r = robotService.getRobotByRobotId(robotId);
    return new ResponseEntity<Robot>(r, HttpStatus.OK);
  }

  @ApiOperation(value = "Add new Robot to store", notes = "adds new robot to store")
  @ApiResponses(value = {@ApiResponse(code = 400, message = "validation errors")})
  @PostMapping
  ResponseEntity<Robot> addRobot(@RequestBody Robot robot) {
    Robot r = robotService.saveRobot(robot);
    return new ResponseEntity<Robot>(r, HttpStatus.OK);
  }

  @ApiOperation(value = "Update Robot", notes = "Updates robot with given robotId")
  @PutMapping(value = "/{robotId}")
  public ResponseEntity<Robot> updateUser(@PathVariable("robotId") String robotId, @RequestBody Robot robot) {
    log.info("Updating Robot with robotId {}", robotId);

    Robot currentRobot = robotService.findByRobotId(robotId);

    if (currentRobot == null) {
      log.error("Unable to update. Robot with robotId {} not found.", robotId);
      return new ResponseEntity("{\"error\":\"robot with productId" + robotId + "not found!\"}", HttpStatus.NOT_FOUND);
    }

    currentRobot.setDescription(robot.getDescription());
    currentRobot.setImageUrl(robot.getImageUrl());
    currentRobot.setPrice(robot.getPrice());

    robotService.updateRobot(currentRobot);
    return new ResponseEntity<Robot>(currentRobot, HttpStatus.OK);
  }


}
