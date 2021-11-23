package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class NgoController {

	
	
	@RequestMapping("/Hello")
	public String helloDonor()
	{
		String msg="Welcome to NGO services";
		return msg;
	}
}
