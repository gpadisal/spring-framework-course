package com.gopal.pma.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.gopal.pma.example.Car;

@Controller
public class TestController {
	
	// When TestController is instantiated, the class fields will be instantiated 
	
	//Field injection add @Autowired
	//@Autowired
	private Car car;

	
	// Constructor injection, we don't need @Autowired because Spring knows it is creating instance with Constructor

//	 public TestController(Car car) { 
//		 this.car = car; 
//	 }
	 
	
	// Setter Injection, comment out field injection and constructor injection
	//WE need @Autowired annotation for setter injection. 
	//because does not know what type of object it is constructing
	
	@Autowired
	public void setCar(Car car) {
		this.car = car;
	}
		
	

}
