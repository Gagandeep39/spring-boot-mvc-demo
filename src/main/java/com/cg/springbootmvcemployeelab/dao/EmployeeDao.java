package com.cg.springbootmvcemployeelab.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.cg.springbootmvcemployeelab.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


/**
 * @author Gagandeep
 * @time 12:15:12 am
 * @date 06-Apr-2020
 */


// create table Emp99 (id INT(20) primary key AUTO_INCREMENT, name varchar(30),
// salary varchar(30), designation varchar(30));

@Repository
public interface EmployeeDao extends JpaRepository<Employee, Integer> {
	
}