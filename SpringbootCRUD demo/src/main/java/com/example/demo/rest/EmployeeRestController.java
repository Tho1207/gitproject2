package com.example.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	private EmployeeService employeeService;
	//inject employee dao
	@Autowired
	public EmployeeRestController(EmployeeService theEmployeeService) {
		employeeService = theEmployeeService;
	}
	
	@GetMapping("/employees")
	public List<Employee> findAll() {
		return employeeService.findAll();
	}
	
	//add mapping for GET/employees/{employeeId}
	@GetMapping("/employees/{employeeId}")
	public Employee getEmployee(@PathVariable int employeeId) {
		Employee theEmployee = employeeService.findById(employeeId);
		if (theEmployee == null) {
			throw new RuntimeException("Employee id not found+ " + employeeId);
		}
		return theEmployee;
	}
	
	//add mapping for POST/employees - add new employee
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee theEmployee ) {
		theEmployee.setId(0); //set 0 to force to save a new item
		employeeService.save(theEmployee);
		return theEmployee;
	}
	
	//add mapping for PUT/employees - updating existing employees
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee theEmployee ) { 
		employeeService.save(theEmployee);
		return theEmployee;
	}
	
	//add Mapping for DELETE/employees/{employeeId} - delete employee
	@DeleteMapping("/employees/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId) {
		Employee tempEmployee = employeeService.findById(employeeId);
		if (tempEmployee == null) {
			throw new RuntimeException("Employee id not found+ " + employeeId);
		}
		employeeService.deleteById(employeeId);
		return "Delete employee Id " + employeeId;

	}
}
 