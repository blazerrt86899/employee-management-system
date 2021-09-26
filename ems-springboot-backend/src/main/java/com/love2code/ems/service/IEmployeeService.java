package com.love2code.ems.service;

import java.util.List;
import java.util.Map;

import com.love2code.ems.model.Employee;
import com.love2code.ems.response.EmployeeResponseStatus;

public interface IEmployeeService {

	EmployeeResponseStatus addEmployeeService(Employee employee);

	List<Employee> getEmployeeListService();

	EmployeeResponseStatus updateEmployeeService(Long id, Employee employee);

	Map<String, Long> deleteEmployeeService(Long id);

	Employee getEmployeeByIdService(Long id);

}
