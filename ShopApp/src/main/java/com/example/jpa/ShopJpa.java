package com.example.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.model.RegisterModel;

public interface ShopJpa extends CrudRepository<RegisterModel, Integer> {
	
	@Query("SELECT password FROM RegisterModel  where userName = :userName "  )
	public String getPassword(@Param("userName") int userName);
	
	
	@Query("SELECT MAX(Id) FROM RegisterModel"  )
	public int  getMaxId();

	  
	 @Query("from RegisterModel where userName=:studentId "  )
	 public List<RegisterModel> getStudentDetailsById(@Param("studentId") int studentId);
	 
	 
	 @Query(" SELECT fullName FROM RegisterModel where userName=:studentId "  )
	 public String getStudentNameById(@Param("studentId") int studentId);

}
