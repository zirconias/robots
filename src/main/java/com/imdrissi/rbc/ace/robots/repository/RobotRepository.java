package com.imdrissi.rbc.ace.robots.repository;

import com.imdrissi.rbc.ace.robots.domain.Robot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface RobotRepository extends JpaRepository<Robot, Long> {

  void deleteByProductId(String productId);

  @Modifying
  @Query("update #{#entityName} e set e.deleted=true where e.productId=?1")
  void softDeleteByProductId(String productId);

}
