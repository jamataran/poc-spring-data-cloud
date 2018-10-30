package com.arrobaautowired.springclouddataflowshell;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.dataflow.shell.EnableDataFlowShell;

@SpringBootApplication
@EnableDataFlowShell
public class SpringCloudDataflowShellApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudDataflowShellApplication.class, args);
	}
}
