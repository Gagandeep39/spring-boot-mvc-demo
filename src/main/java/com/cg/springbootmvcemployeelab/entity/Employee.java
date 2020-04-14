package com.cg.springbootmvcemployeelab.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 
 * @author Gagandeep
 * @time 8:04:45 am
 * @date 09-Apr-2020
 */

@Entity
@Table(name = "emps_lab_table")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;

	@NotNull(message = "Field cannot be Empty")
	@Size(min = 3, max = 20, message = "Must be between 3-20 Characters")
	@Column(name = "firstName")
	private String firstName;

	@NotNull(message = "Field cannot be Empty")
	@Size(min = 3, max = 20, message = "Must be between 3-20 Characters")
	@Column(name = "lastName")
	private String lastName;

	@NotNull(message = "Field cannot be Empty")
	@Column(name = "gender")
	private String gender;

	@NotNull(message = "Select an Option")
	@Column(name = "skillSet")
	private String skillSet;

	/**
	 * 
	 */
	public Employee() {
	}

	/**
	 * @param firstName
	 * @param lastName
	 * @param gender
	 * @param skillSet
	 */
	public Employee(String firstName, String lastName, String gender, String skillSet) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.skillSet = skillSet;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return the skillSet
	 */
	public String getSkillSet() {
		return skillSet;
	}

	/**
	 * @param skillSet the skillSet to set
	 */
	public void setSkillSet(String skillSet) {
		this.skillSet = skillSet;
	}

	@Override
	public String toString() {
		return "Employee{" +
				"id=" + id +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", gender='" + gender + '\'' +
				", skillSet='" + skillSet + '\'' +
				'}';
	}
}

/*
 * 1. Login Page (default: admin, admin) 2. Redirect to Employee Management
 * System (Perform CRUD Operations using JPA) 3. Employee Bean -> ID ->
 * FirstName -> Last Name -> Gender (radio) -> Skillset (Dropdown)
 * 
 */
