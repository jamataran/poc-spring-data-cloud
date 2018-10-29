package com.arrobaautowired.springclouddataflowserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.dataflow.server.EnableDataFlowServer;

@EnableDataFlowServer
@SpringBootApplication
public class SpringCloudDataflowServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudDataflowServerApplication.class, args);
	}
}
