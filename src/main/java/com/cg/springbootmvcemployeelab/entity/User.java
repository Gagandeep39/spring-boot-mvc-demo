package com.cg.springbootmvcemployeelab.entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author Gagandeep
 * @time 1:18:06 pm
 * @date 08-Apr-2020
 */
public class User {
	

	@NotNull(message = "Can't be null")	
	@Size(min = 4, message = "Minimum lengthh should be 4")
	private String username;
	
	@NotNull(message = "Can't be null")	
	@Size(min = 4, message = "Minimum lengthh should be 4")
	private String password;
	
	public User(){}
	
	/**
	 * @param username
	 * @param password
	 */
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + "]";
	}
	
	

}
