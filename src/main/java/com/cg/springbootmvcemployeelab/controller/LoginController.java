/**
 * 
 */
package com.cg.springbootmvcemployeelab.controller;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.validation.Valid;

import com.cg.springbootmvcemployeelab.dao.EmployeeDao;
import com.cg.springbootmvcemployeelab.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;



/**
 * @author Gagandeep
 * @time 12:15:12 am
 * @date 06-Apr-2020
 */

@Controller
@RequestMapping(value = "/loginCtrl") // class level annotation
public class LoginController {

	@RequestMapping("/processForm")
	public String processForm(
		@ModelAttribute("user") @Valid User user,
		BindingResult bindingResult,
		RedirectAttributes attributes
			) {
		System.out.println(user);
		System.out.println(bindingResult);
		if(bindingResult.hasErrors())
			return "loginform";
		attributes.addFlashAttribute("user", user);
		System.out.println(user);
		return "redirect:/loginCtrl/ValidateLogin";
	}
	
	
	
	
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		StringTrimmerEditor editor = new StringTrimmerEditor(true);
		webDataBinder.registerCustomEditor(String.class, editor);
	}
		
	

	@RequestMapping(value = "/ValidateLogin") // method-level
	public String login(@ModelAttribute("user") User user, Model model) {
		
		System.out.println("Inside Login Function" + user);
		if (user.getUsername().equals("admin") && user.getPassword().equals("admin")) {
			String valid = "Welcome " + user.getUsername() + ", You are a valid user ";
			model.addAttribute("message", valid);
			return "redirect:/empCtrl/empInit";
		} else {
			String invalid = "Welcome " + user.getUsername() + " you are invalid";
			model.addAttribute("message", invalid);
			return "invalid";
		}
	}
	
	@RequestMapping(value = "/LoginForm")
	public String showLoginPage(Model model) {
		System.out.println("-----------------------");
		model.addAttribute("user", new User());
		return "loginform";
	}

	/**
	 * To traditionally test database connection 
	 */
	private void testDatabase() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "gagan",
					"12345");
			System.out.println(connection);
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	
}
