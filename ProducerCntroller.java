package com.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dto.Employee;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class ProducerCntroller {
	
	//@GetMapping(value="/getemployee")
	@RequestMapping(method=RequestMethod.GET, value="employee")
	@HystrixCommand(fallbackMethod="getFallBack")
	public Employee getEmp() {
		Employee e1 = new Employee();
		e1.setEmpId(102);
		e1.setEmpName("manzar");
		
		if(e1.getEmpName().equals("manzar"))
			throw new RuntimeException();
		return e1;
	}
	
	
	public Employee getFallBack() {
		Employee e1 = new Employee();
		e1.setEmpId(103);
		e1.setEmpName("eshwar");
		return e1;
	}
	

}
