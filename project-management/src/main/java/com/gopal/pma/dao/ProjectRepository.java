package com.gopal.pma.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.gopal.pma.entity.Project;

public interface ProjectRepository extends CrudRepository<Project, Long>{
	
	@Override
	List<Project> findAll();

}
