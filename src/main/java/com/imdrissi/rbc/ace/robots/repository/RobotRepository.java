package com.imdrissi.rbc.ace.robots.repository;

import com.imdrissi.rbc.ace.robots.domain.Robot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RobotRepository extends JpaRepository<Robot, Long> {

  void deleteByProductId(String productId);

  @Modifying
  @Query("update #{#entityName} e set e.deleted=true where e.productId=?1")
  void softDeleteByProductId(String productId);

  @Query("select e from #{#entityName} e where e.deleted=false")
  public List<Robot> findAllNotDeleted();

  @Query("select e from #{#entityName} e where e.deleted=true")
  public List<Robot> findBin();

}
