/**
 * Gagandeep
 * 2:50:03 pm
 * 09-Apr-2020
 */
package com.cg.springbootmvcemployeelab.service;

import java.util.List;

import com.cg.springbootmvcemployeelab.entity.Employee;

public interface EmployeeService {
	
	public Employee addEmployee(Employee employee);
	public Employee updateEmployee(Employee employee);
	public List<Employee> fetchAll();
	public void deleteEmployee(int id);
	public Employee fetchById(int id);

}
