package com.gopal.pma.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//This class will be scanned for Bean definitions with class annotated with @Configuration
//Create a bean of Type Car and will be added into Spring Context.
//the bean is available for @autowired

// or Bean definitions from Main Spring Application 

@Configuration
public class ManufacturingConfig {
	
	@Bean
	public Car newCar() {
		return new Car(new Engine(), new Tires(), new Steering());
	}

}
