package com.example.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.model.SectionMaster;

public interface SectionJpa extends CrudRepository<SectionMaster, Integer> {
	 @Query("  FROM SectionMaster where studentcClass=:studentClass "  )
	 public List<SectionMaster> getSectionByClass(@Param("studentClass") int studentClass);
	 
	 @Query("SELECT section FROM SectionMaster where studentcClass like %:keyword%")
		public List<String> search(@Param("keyword") int  keyword);

}
