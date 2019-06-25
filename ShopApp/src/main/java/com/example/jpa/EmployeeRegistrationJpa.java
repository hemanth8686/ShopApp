package com.example.jpa;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.model.EmployeeRegistrationModel;

public interface EmployeeRegistrationJpa extends CrudRepository<EmployeeRegistrationModel, Integer> {
	@Query("SELECT MAX(Id) FROM RegisterModel"  )
	public int  getMaxId();

}
