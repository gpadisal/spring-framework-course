package com.gopal.pma.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Employee {
	
	@Id
	@GeneratedValue
	private long employeeId;
	private String firstName;
	private String lastName;	
	private String email;
	
	
	/**
	 * ManyToOne Relation uncomment the following block
	 * 
	 * //many employees can be assigned to one project, hence many to one relation
	// Join column is the foreign key created in Employee Table
	// Project field name theProject must match with mappedBy in Project Entity
		@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},
				fetch = FetchType.LAZY)
		
		//cascade means if parent is delete
		
		@JoinColumn(name = "project_id")
		private Project project;
	 */
	
	/**
	 * Following block is for Many to Many relation from Project to Employee.
	 */
	
	@ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},
			fetch = FetchType.LAZY)
	@JoinTable(name = "project_employee", 
				joinColumns=@JoinColumn(name="employee_id"),
				inverseJoinColumns=@JoinColumn(name="project_id"))
	private List<Project> projects;
	
	
	public Employee() {
		
	}
	
	public Employee(String firstName, String lastName, String email) {
		this();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	public long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	/*  uncomment for ManyToOne relation
	 * public Project getProject() { return project; }
	 * 
	 * public void setProject(Project project) { this.project = project; }
	 */
	

}
