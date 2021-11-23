package com.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exception.DuplicateEmployeeException;
import com.model.Employee;
import com.service.AdminServiceImpl;
import com.service.IAdminService;


@RestController
public class AdminController {

	@Autowired
	AdminServiceImpl adminService;
	
	@RequestMapping("/Hello")
	public String helloDonor()
	{
		String msg="Welcome to NGO services";
		return msg;
	}
	//add employee
	@PostMapping("/employee/add")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) throws DuplicateEmployeeException, SQLException
	{
		Employee emp=adminService.addEmployee(employee);
		return new ResponseEntity<Employee>(emp,HttpStatus.CREATED);
	}
}
