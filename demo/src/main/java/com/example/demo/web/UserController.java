package com.example.demo.web;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Product;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@RequestMapping("/{userId}")
	public String displayUser(@PathVariable String userId) {
		return "User found" + userId;
	}
	
	//http://localhost:8080/users/2/invoices?date=12/22/2020
	@RequestMapping("{userId}/invoices")
	public String getUserInvoices(@PathVariable int userId, @RequestParam Date date) {
		return "user found:" + userId  + " for date:" + date;
		
	}
	
	// Rename the request Param and path variable from the variables used in code for them.
	//http://localhost:8080/users/2/invoices2?d=12/22/2020
	@RequestMapping("{id}/invoices2")
	public String getUserInvoices2(@PathVariable(value = "id") int userId, @RequestParam(value = "d", required = false) Date date) {
		return "user found:" + userId  + " for date:" + date;
		
	}
	
	//Return json of list, returns as array with sq brackets
	@RequestMapping("{id}/items")
	public List<String> displayStringJson(@PathVariable(value = "id") int userId) {
		return Arrays.asList("Shoes", "Laptop", " Button");
	}
	
	
	//Return json of Products
	//http://localhost:8080/users/2/products
	@RequestMapping("{id}/products")
	public List<Product> displayProducts(@PathVariable(value = "id") int userId) {
		return Arrays.asList(
				new Product(1, "Shoes", 45.20),
				new Product(1, "Laptop", 500.99),
				new Product(1, "Bag", 20.20)				
				);
	}
		

}
