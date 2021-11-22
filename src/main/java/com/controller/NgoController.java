package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.AdminServiceImpl;

@RestController
public class NgoController {

	@Autowired
	AdminServiceImpl adminService;
	
	@RequestMapping("/Hello")
	public String helloDonor()
	{
		String msg="Welcome to NGO services";
		return msg;
	}
}
