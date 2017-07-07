package com.imdrissi.rbc.ace.robots.service;


import com.imdrissi.rbc.ace.robots.domain.Robot;
import com.imdrissi.rbc.ace.robots.repository.RobotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RobotService {

  @Autowired
  private RobotRepository robotRepository;


  public Iterable<Robot> allRobots() {
    return robotRepository.findAll();
  }


  public Robot getRobotById(Long id) {
    return robotRepository.findOne(id);
  }

  public Robot saveRobot(Robot robot) {
    return robotRepository.save(robot);
  }

  public void deleteRobot(Long id) {
    robotRepository.delete(id);
  }


}
