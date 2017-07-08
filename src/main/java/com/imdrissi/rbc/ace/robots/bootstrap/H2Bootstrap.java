package com.imdrissi.rbc.ace.robots.bootstrap;

import com.imdrissi.rbc.ace.robots.domain.Authority;
import com.imdrissi.rbc.ace.robots.domain.Robot;
import com.imdrissi.rbc.ace.robots.domain.User;
import com.imdrissi.rbc.ace.robots.repository.AuthorityRepository;
import com.imdrissi.rbc.ace.robots.repository.UserRepository;
import com.imdrissi.rbc.ace.robots.service.RobotService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;

@Profile({"dev", "test"})
@Component
public class H2Bootstrap implements CommandLineRunner {
  private static final Logger log = LoggerFactory.getLogger(H2Bootstrap.class);

  @Autowired
  RobotService robotService;
  @Autowired
  UserRepository userRepository;
  @Autowired
  AuthorityRepository authorityRepository;

  @Override
  public void run(String... strings) throws Exception {
    initAuthorities();
    initUsers();
    initRobots();
  }


  private void initUsers() {
    log.info("bootstrap users");
    Authority adminAuth = authorityRepository.findByName("ADMIN");
    Authority userAuth = authorityRepository.findByName("USER");
    Authority managerAuth = authorityRepository.findByName("MANAGER");

    User admin = new User("admin", new BCryptPasswordEncoder().encode("admin"));
    admin.setAuthorities(new ArrayList<>(Arrays.asList(adminAuth, managerAuth)));
    userRepository.save(admin);

    User manager = new User("manager", new BCryptPasswordEncoder().encode("manager"));
    manager.setAuthorities(new ArrayList<>(Arrays.asList(managerAuth)));
    userRepository.save(manager);

    User user = new User("user", new BCryptPasswordEncoder().encode("user"));
    user.setAuthorities(new ArrayList<>(Arrays.asList(userAuth)));
    userRepository.save(user);
  }

  private void initAuthorities() {
    log.info("bootstrap authorities");
    Authority adminAuth = new Authority("ADMIN");
    Authority managerAuth = new Authority("MANAGER");
    Authority userAuth = new Authority("USER");
    authorityRepository.saveAndFlush(adminAuth);
    authorityRepository.saveAndFlush(managerAuth);
    authorityRepository.saveAndFlush(userAuth);
  }

  private void initRobots() {
    log.info("bootstrap robots");
    Robot robot1 = new Robot();
    robot1.setDescription("Guru");
    robot1.setPrice(new BigDecimal("18.95"));
    robot1.setImageUrl("http://www.mobile.guru/wp-content/uploads/2015/10/shutterstock_137265305.jpg");
    robot1.setRobotId("235268845711068308");
    robotService.saveRobot(robot1);

    Robot robot2 = new Robot();
    robot2.setDescription("Guru pro");
    robot2.setImageUrl("http://orig04.deviantart.net/fae7/f/2014/292/7/3/retro_robot_meditation___free_vector_by_pixaroma-d83i1t9.png");
    robot2.setRobotId("168639393495335947");
    robot2.setPrice(new BigDecimal("11.95"));
    robotService.saveRobot(robot2);

  }
}
