package com.gopal.pma.services;

import org.springframework.stereotype.Service;


//with out service annotation , this instance will not be created by Spring context

//When class is annotated with @Service, @Repository, @Component and other annotations
//the instance is created and added into Spring context. the bean is available for autowired by other classes

// Repository with data,
// Service, service calls
// Component, if we dont know the purpose of this class, we can mark it with component

// Component scanning happens in the main package where main application is created ProjectManagementApplication
// main package com.gopal.pma and sub packages will be scanned for annotated classes and beans will be created.

// if classes is created outside of com.gopal.pma, that class will not be scanned

@Service
public class DataCleansingService {

	public DataCleansingService() {
		super();
	}

}
