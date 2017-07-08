package com.imdrissi.rbc.ace.robots.repository;

import com.imdrissi.rbc.ace.robots.domain.Robot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RobotRepository extends JpaRepository<Robot, Long> {

  void deleteByRobotId(String robotId);

  @Modifying
  @Query("update #{#entityName} e set e.deleted=true where e.robotId=?1")
  void softDeleteByRobotId(String robotId);

  @Query("select e from #{#entityName} e where e.deleted=false")
  public List<Robot> findAllNotDeleted();

  @Query("select e from #{#entityName} e where e.deleted=true")
  public List<Robot> findBin();

  Robot findByRobotId(String robotId);
}
