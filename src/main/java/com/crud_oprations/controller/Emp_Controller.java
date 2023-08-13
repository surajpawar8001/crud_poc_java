package com.crud_oprations.controller;

import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.crud_oprations.entity.Employee;
import com.crud_oprations.service.Emp_Service;

@Controller
public class Emp_Controller {

	@Autowired
	private Emp_Service service;
	
	@GetMapping("/")
	public String home(Model m) {
		
	List<Employee> emp = service.getallemp();
		m.addAttribute("emp",emp);
		
		
		return "index";
	}
	
	
	@GetMapping("/addemp")
	public String addempform() {
		return "add_emp";
	}
	
	
	@PostMapping("/register")
	public String empregister(@ModelAttribute Employee e,HttpSession session ) {
		
		System.out.println(e);
		
		service.addemp(e);
		
		session.setAttribute("msg","Employee Added Sucessfully...!");
		return "redirect:/";
		
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable int id, Model m) {
		
		
	Employee e =	service.getempbyid(id);
		
	m.addAttribute("emp",e);
		return "edit";
	}
	
	
	@PostMapping("/update")
	public String updateemp(@ModelAttribute Employee e, HttpSession session) {
		service.addemp(e);
		session.setAttribute("msg", "Emp Data Update Sucessfully...!");
		return "redirect:/";
	}
	
	
	@GetMapping("/delete/{id}")
	public String deleteemp(@PathVariable int id, HttpSession session) {
		
		
		service.deleteemp(id);
		session.setAttribute("msg","Emp Data delete Sucessfully...!");
		return"redirect:/";
	}
	
	

	
}
