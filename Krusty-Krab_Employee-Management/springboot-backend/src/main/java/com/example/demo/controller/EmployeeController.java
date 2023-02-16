package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.ResourceNotFoundExc;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepo;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/v1/")
public class EmployeeController {
	
	@Autowired
	private EmployeeRepo employee_repo;
	
	//get all employees
	@GetMapping("/employees")
	public List<Employee> getAllEmployees(){
		return employee_repo.findAll();
	}
	
	//create employee 
	@PostMapping("/employees")
	public Employee createEmploye(@RequestBody Employee employee) {
		return employee_repo.save(employee);
	}
	
	//get employee by id
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployByid(@PathVariable long id) {
		Employee employee = employee_repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundExc("Employee not found by id: " + id));
		return ResponseEntity.ok(employee);
	}
	
	//update employee by id
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployByid(@PathVariable long id,@RequestBody Employee emp){
		Employee employee = employee_repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundExc("Employee not found by id: " + id));
		
		employee.setFirst_name(emp.getFirst_name());
		employee.setLast_name(emp.getLast_name());
		employee.setHourly_pay(emp.getHourly_pay());
		
		Employee updateEmployee = employee_repo.save(employee);
		
		return ResponseEntity.ok(updateEmployee);
	}
	
	//delete employee
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Map<String, Boolean>>deleteEmployee(@PathVariable long id){
		Employee employee = employee_repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundExc("Employee not found by id: " + id));
		
		employee_repo.delete(employee);
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("Deleted", Boolean.TRUE);
		
		return ResponseEntity.ok(response);
	}
	
	
}
