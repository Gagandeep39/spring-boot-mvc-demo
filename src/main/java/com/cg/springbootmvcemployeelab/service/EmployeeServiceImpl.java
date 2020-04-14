/**
 * Gagandeep
 * 2:50:50 pm
 * 09-Apr-2020
 */
package com.cg.springbootmvcemployeelab.service;

import java.util.List;
import java.util.Optional;

import com.cg.springbootmvcemployeelab.dao.EmployeeDao;
import com.cg.springbootmvcemployeelab.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * If we dont add trasactional then JPA repository wont work, will give error
 */
@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeDao dao;


	@Override
	public Employee addEmployee(Employee employee) {
		return dao.save(employee);
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		return dao.save(employee);
	}

	@Override
	public List<Employee> fetchAll() {
		return dao.findAll();
	}

	@Override
	public void deleteEmployee(int id) {
		dao.deleteById(id);
	}

	@Override
	public Employee fetchById(int id) {
		Optional<Employee> employee = dao.findById(id);
		if (employee.isPresent()) {
			return dao.findById(id).get();
		} else return null;
	}
}
