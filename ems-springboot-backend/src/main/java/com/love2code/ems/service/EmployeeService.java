package com.love2code.ems.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.love2code.ems.exception.RecordNotFoundException;
import com.love2code.ems.model.Employee;
import com.love2code.ems.repository.IEmployeeRepository;
import com.love2code.ems.response.EmployeeResponseStatus;

@Service
public class EmployeeService implements IEmployeeService {

	@Autowired
	private IEmployeeRepository employeeRepository;

	@Override
	public EmployeeResponseStatus addEmployeeService(Employee employee) {
		employee.setEmployeeCode(UUID.randomUUID().toString());
		employeeRepository.save(employee);
		return new EmployeeResponseStatus("Employee Created.");
	}

	@Override
	public List<Employee> getEmployeeListService() {
		return employeeRepository.findAll();
	}

	@Override
	public EmployeeResponseStatus updateEmployeeService(Long id, Employee employee) {
		Employee employeeById = employeeRepository.findById(id)
				.orElseThrow(() -> new RecordNotFoundException("Employee does not exist with id " + id));
		employeeById.setName(employee.getName());
		employeeById.setEmail(employee.getEmail());
		employeeById.setPhoneNumber(employee.getPhoneNumber());
		employeeById.setJobTitle(employee.getJobTitle());
		employeeById.setImgUrl(employee.getImgUrl());
		employeeRepository.save(employeeById);
		return new EmployeeResponseStatus("Employee Updated with id " + id);
	}

	@Override
	public Map<String, Long> deleteEmployeeService(Long id) {
		Map<String, Long> deleteResponse = new HashMap<String, Long>();
		Employee checkEmployee = employeeRepository.findById(id)
				.orElseThrow(() -> new RecordNotFoundException("Employee with id " + id + " is not present"));
		if (checkEmployee != null) {
			employeeRepository.deleteById(id);
			deleteResponse.put("Employee Deleted", id);
		} else {
			deleteResponse.put("Employee Not Deleted ", id);
		}

		return deleteResponse;
	}

	@Override
	public Employee getEmployeeByIdService(Long id) {
		return employeeRepository.findById(id)
				.orElseThrow(() -> new RecordNotFoundException("Employee does not exist with id " + id));
	}

}
