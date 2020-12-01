package com.gopal.pma.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.gopal.pma.dto.ProjectStage;
import com.gopal.pma.entity.Project;

public interface ProjectRepository extends CrudRepository<Project, Long>{
	
	@Override
	List<Project> findAll();
	
	@Query(nativeQuery=true, value="SELECT stage as label, count(stage) as value FROM PROJECT " + 
			"group by stage")
	List<ProjectStage> projectStages();
	

}
