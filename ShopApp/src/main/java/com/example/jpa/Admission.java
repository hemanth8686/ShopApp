package com.example.jpa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.core.CrudMethods;

import com.example.model.StudentAdmission;

public interface Admission extends CrudRepository<StudentAdmission, Integer> {

}
