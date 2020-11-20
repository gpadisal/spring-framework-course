package com.example.demo.web;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * Sample Controller to demonstrate the Rest API calls
 * @author 515659
 *
 */
@RestController
@RequestMapping("/greeting")
public class HelloController {
	
	@RequestMapping(value="/basic", method= RequestMethod.GET)
	public String getHello() {
		return "<h1>Hello</h1>";
	}
	
	@RequestMapping(value="/proper", method= RequestMethod.GET)
	public String getHelloProper() {
		return "<h1>Hello there, how are you</h1>";
	}
	
	//http://localhost:8080/greeting/user_entry
	@RequestMapping("/user_entry")
	public String userForm() {
		return "<form action=\"/greeting/user_greeting\" method=\"post\">\r\n" + 
				"  <label for=\"fname\">First name:</label><br>\r\n" + 
				"  <input type=\"text\" name=\"fname\"><br>\r\n" + 
				"  <label for=\"lname\">Last name:</label><br>\r\n" + 
				"  <input type=\"text\" name=\"lname\"><br><br>\r\n" + 
				"  <input type=\"submit\" value=\"Submit\">\r\n" + 
				"</form> ";
	}
	
	// Form Submission
	// Request Param must match with name field of fname and lname inputs
	@RequestMapping(value="/user_greeting", method=RequestMethod.POST)
	public String printUserGreeting(@RequestParam String fname, @RequestParam String lname) {
		return "form submitted: for " +  fname + " , "+ lname;
	}
	
	//http://localhost:8080/greeting/orders/2
	@RequestMapping(value="/orders/{id}", method= RequestMethod.GET)
	public String getOrder(@PathVariable String id) {
		return "Order Id : " + id;
	}	
	
	

}
