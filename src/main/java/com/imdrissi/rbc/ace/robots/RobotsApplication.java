package com.imdrissi.rbc.ace.robots;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.imdrissi.rbc.ace.robots"})
public class RobotsApplication {

	public static void main(String[] args) {
		SpringApplication.run(RobotsApplication.class, args);
	}
}
