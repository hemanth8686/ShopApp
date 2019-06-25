package com.example.jpa;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.model.FeeMasterModel;

public interface FeeMasterJpa extends CrudRepository<FeeMasterModel, Integer> {
	@Query("SELECT Fee FROM FeeMasterModel  where studentClass = :name "  )
	public int  getfee(@Param("name") int name);
	

}
