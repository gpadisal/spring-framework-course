package com.gopal.pma.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Project {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long projectId;
	private String name;
	private String stage;
	private String description;
	
	/** OneToMany relation one project contains many employees
	 * 
		 * 	
		//A project assigned to many employees. So Project entity needs to have list of employees
		// mappedBy column is the field in Employee entity to which employee is assigned to project
		@OneToMany(mappedBy = "project")
		private List<Employee> employees;
	 * 
	 */

	/**
	 * ManayToMany Relation, project_employee is table name and it contains columns project_id and employee_id
	 * join column is project_id in Project Entity and inverse join column is employee_id in other table
	 * Follow the reverse order in Employee Entity
	 */
	
	@ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},
			fetch = FetchType.LAZY)
	@JoinTable(name = "project_employee", 
				joinColumns=@JoinColumn(name="project_id"),
				inverseJoinColumns=@JoinColumn(name="employee_id"))
	private List<Employee> employees;

	
	public Project() {			
	}
	
	public Project(String name, String stage, String description) {
		this();
		this.setName(name);
		this.stage = stage;
		this.description = description;
	}

	public long getProjectId() {
		return projectId;
	}
	public void setProjectId(long projectId) {
		this.projectId = projectId;
	}

	public String getStage() {
		return stage;
	}
	public void setStage(String stage) {
		this.stage = stage;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	
}
