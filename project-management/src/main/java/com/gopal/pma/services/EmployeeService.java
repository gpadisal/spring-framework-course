package com.gopal.pma.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
	

	//Where there multiple beans implementing, to inject one of the implemented classes.
	// 1. Add @Primary on one of the classes in that class definition
	// 2. Add @Qualifier("staffRepo1") on Constructor or Setter or field injection
	
	//@Autowired
	//@Qualifier("staffRepo1")
	StaffRepository staffRepository;



	
	
//	public EmployeeService(@Qualifier("staffRepo1")StaffRepository staffRepository) {
//		this.staffRepository = staffRepository;
//	}
//	
	
	@Autowired
	@Qualifier("staffRepo1")
	public void setStaffRepository(StaffRepository staffRepository) {
		this.staffRepository = staffRepository;
	}
	

}
