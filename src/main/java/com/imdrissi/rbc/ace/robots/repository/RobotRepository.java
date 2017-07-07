package com.imdrissi.rbc.ace.robots.repository;

import com.imdrissi.rbc.ace.robots.domain.Robot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RobotRepository extends JpaRepository<Robot, Long> {

  void deleteByProductId(String productId);

}
