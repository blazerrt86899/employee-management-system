package com.love2code.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.love2code.ems.model.Employee;
@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, Long> {

}
