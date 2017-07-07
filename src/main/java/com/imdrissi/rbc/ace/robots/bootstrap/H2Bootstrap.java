package com.imdrissi.rbc.ace.robots.bootstrap;

import com.imdrissi.rbc.ace.robots.domain.Robot;
import com.imdrissi.rbc.ace.robots.service.RobotService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Profile({"dev", "test"})
@Component
public class H2Bootstrap implements CommandLineRunner {
  private static final Logger log = LoggerFactory.getLogger(H2Bootstrap.class);

  @Autowired
  RobotService robotService;

  @Override
  public void run(String... strings) throws Exception {
    log.info("populating dev data tables");

    Robot robot1 = new Robot();
    robot1.setDescription("Guru");
    robot1.setPrice(new BigDecimal("18.95"));
    robot1.setImageUrl("http://www.mobile.guru/wp-content/uploads/2015/10/shutterstock_137265305.jpg");
    robot1.setProductId("235268845711068308");
    robotService.saveRobot(robot1);

    log.info("Saved Shirt - id: " + robot1.getId());

    Robot robot2 = new Robot();
    robot2.setDescription("Guru pro");
    robot2.setImageUrl("http://orig04.deviantart.net/fae7/f/2014/292/7/3/retro_robot_meditation___free_vector_by_pixaroma-d83i1t9.png");
    robot2.setProductId("168639393495335947");
    robot2.setPrice(new BigDecimal("11.95"));
    robotService.saveRobot(robot2);

    Iterable<Robot> itr = robotService.allRobots();
    for (Robot r : itr) {
      log.info("product: " + r.getDescription());
    }
  }
}
