package com.love2code.ems.resource;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.love2code.ems.model.Employee;
import com.love2code.ems.response.EmployeeResponseStatus;
import com.love2code.ems.service.IEmployeeService;

@RestController
@RequestMapping(path = "/api/v1/employee")
public class EmployeeResource {
	
	@Autowired
	private IEmployeeService employeeService;
	
	@PostMapping(path = "/add", consumes = "application/json", produces = "application/json")
	public ResponseEntity<EmployeeResponseStatus> addEmployee(@RequestBody Employee employee){
		EmployeeResponseStatus addEmployeeResponse = 
				employeeService.addEmployeeService(employee);
		return ResponseEntity.status(HttpStatus.CREATED).body(addEmployeeResponse);
	}
	
	@GetMapping(path = "/get-list")
	public ResponseEntity<List<Employee>> getEmployeeList(){
		List<Employee> employeeList = employeeService.getEmployeeListService();
		return ResponseEntity.status(HttpStatus.OK).body(employeeList);
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id){
		Employee employee = employeeService.getEmployeeByIdService(id);
		return ResponseEntity.status(HttpStatus.OK).body(employee);
	}
	
	@PutMapping(path = "/update/{id}", consumes = "application/json", produces = "application/json")
	public ResponseEntity<EmployeeResponseStatus> updateEmployee(@PathVariable("id") Long id, @RequestBody Employee employee){
		EmployeeResponseStatus updateResponse = employeeService.updateEmployeeService(id,employee);
		return ResponseEntity.status(HttpStatus.CREATED).body(updateResponse);
	}
	
	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<Map<String, Long>> deleteEmployee(@PathVariable("id") Long id){
		Map<String, Long> deletedResponse = employeeService.deleteEmployeeService(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(deletedResponse);
	}

}
