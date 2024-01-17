package com.springbootrestapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootrestapi.dao.EmployeeRepository;
import com.springbootrestapi.entity.Employee;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	public Employee saveEmployee(Employee employee) {
	    return this.employeeRepository.save(employee);
	}
	
	public List<Employee> saveEmployees(List<Employee> employees) {
	    return this.employeeRepository.saveAll(employees);
	}
	
	public List<Employee> getEmployee(){
		return this.employeeRepository.findAll();
	}
	
	public Employee getEmployeeById(int id) {
		return this.employeeRepository.findById(id).orElse(null);
	}
	
	public Employee updateEmployee(Employee employee) {
	  Employee existingEmployee=employeeRepository.findById(employee.getId()).orElse(employee);
	  existingEmployee.setName(employee.getName());
	  existingEmployee.setAddress(employee.getAddress());
	  existingEmployee.setFees(employee.getFees());
	  existingEmployee.setFathername(employee.getFathername());
	  return employeeRepository.save(existingEmployee);
	}
	
	public String deleteEmployeeById(int id) {
		 this.employeeRepository.deleteById(id);
		return "Employee removed :"+id;
	}
}
