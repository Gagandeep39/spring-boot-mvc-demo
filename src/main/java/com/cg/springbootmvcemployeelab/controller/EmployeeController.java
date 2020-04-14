package com.cg.springbootmvcemployeelab.controller;

import com.cg.springbootmvcemployeelab.entity.Employee;
import com.cg.springbootmvcemployeelab.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import javax.validation.Valid;

/**
 * @author Gagandeep
 * @time 12:51:20 pm
 * @date 08-Apr-2020
 */
@Controller
@RequestMapping("/empCtrl")
public class EmployeeController {
	
	/**
	 * Starting a redirct: with '/' will make it create a new path
	 */

	@Autowired
	private EmployeeService service;
	
	
//	http://localhost:8085/empCtrl/empForm
	@RequestMapping(value = "/empForm")
	public ModelAndView showform() {
		System.out.println("Going to Employee Form");
		return new ModelAndView("empform", "employee", new Employee());
	}

	@RequestMapping("/processEmp")
	public ModelAndView processEmp(@Valid @ModelAttribute("employee") Employee emp, BindingResult result) {
		System.out.println("Inside Process Emp");
		System.out.println(result);
		if(result.hasErrors())	{
			return new ModelAndView("empform", "employee", emp);
		}
		service.addEmployee(emp);
		return new ModelAndView("redirect:/empCtrl/viewemp", "emp", emp);
	}


	@RequestMapping("/viewemp")
	public ModelAndView viewemp() {
		List<Employee> list = service.fetchAll();
		System.out.println(list);
		return new ModelAndView("home", "list", list);
	}
	
	@RequestMapping("/empInit")
	public String employeeInit() {
		return "redirect:/empCtrl/viewemp";
	}

	@RequestMapping(value = "/editemp/{id}")
	public ModelAndView edit(@PathVariable int id, Model m) {
		System.out.println("EDIT-----------");
		Employee emp = service.fetchById(id);
		return new ModelAndView("/empform", "employee", emp);
	}


	@RequestMapping("/editemp/processEmp")
	public ModelAndView updateEmp(@Valid @ModelAttribute("employee") Employee emp, BindingResult result) {
		if(result.hasErrors())	{
			return new ModelAndView("empform", "employee", emp);
		}
		service.updateEmployee(emp);
		return new ModelAndView("redirect:/empCtrl/viewemp", "emp", emp);
		
	}

	// Here we are specifiying full path as the request i scoming from ahref (We dont do it incase  of form taglib)
	@RequestMapping(value = "/deleteemp/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable int id) {
		service.deleteEmployee(id);
		return "redirect:/empCtrl/viewemp";
	}
	
	/**
	 * To make empty string null
	 * @param webDataBinder
	 */
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		StringTrimmerEditor editor = new StringTrimmerEditor(true);
		webDataBinder.registerCustomEditor(String.class, editor);
	}
}
