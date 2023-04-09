package io.iam149cm.springbootdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/** @SpringBootApplication contains below 3 annotations :
 * 		1. @SpringBootConfiguration : contains @Configuration (Java based configuration)
 * 			- @Configuration : indicates that a class declares one or more @Bean methods and
 * 			  may be processed by the Spring container to generate bean definitions and service requests for those beans at runtime
 * 		2. @EnableAutoConfiguration : Enable Spring Boot's auto-configuration mechanism
 * 		3. @ComponentScan : Enable @Component scan on the package where the application is located
 */
@SpringBootApplication
public class SpringbootDemoApplication {

	public static void main(String[] args) {
		/**
		 * 		 SpringApplication.run() method performs bootstrapping of the application and starts the Spring application context
		 * 		 bootstrapping: load the application context, create the beans, etc.
		 *
		 * 		 .run() method internally contains the IOC container (ApplicationContext) based on the classpath
		 * 		 - StopWatch starts
		 * 		 - Prepare the environment
		 * 		 - Print banner
		 * 		 - Start the ICO container
		 * 		 - Refresh context
		 * 		 - Trigger Runners
		 * 		 - Return ApplicationContext reference(spring IOC container)
		 *
		 */

		SpringApplication.run(SpringbootDemoApplication.class, args);


	}

}
