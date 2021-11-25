package com.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.NeedyPeople;
import com.service.EmployeeServiceImpl;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeServiceImpl empService;

	@RequestMapping("NeedyPerson/Hello")
	public String helloAdmin() {
		String msg = "Welcome to NeedyPeople services";
		return msg;
	}

	@PostMapping("needyPerson/add")
	public ResponseEntity<NeedyPeople> addNeedyPerson(@Valid @RequestBody NeedyPeople person) {
		NeedyPeople p = empService.addNeedyPerson(person);
		return new ResponseEntity<>(p, HttpStatus.CREATED);
	}

	@DeleteMapping(path = "needyPerson/delete")
	public ResponseEntity<NeedyPeople> deleteNeedyPerson(@RequestBody NeedyPeople person) {
		empService.removeNeedyPerson(person);
		ResponseEntity<NeedyPeople> re = new ResponseEntity<NeedyPeople>(HttpStatus.OK);
		return re;
	}

	@GetMapping(path = "/needyPeople/getById/{id}")
	public ResponseEntity<NeedyPeople> getNeedyPeopleById(@PathVariable("id") int id) {
		NeedyPeople p = empService.findNeedyPeopleById(id);
		return new ResponseEntity<NeedyPeople>(p, HttpStatus.OK);
	}

	@GetMapping(path = "/needyPeople/getByName/{name}")
	public ResponseEntity<NeedyPeople> getNeedyPeopleByName(@PathVariable("name") String name) {
		NeedyPeople n = empService.findNeedyPeopleByName(name);
		return new ResponseEntity<NeedyPeople>(n, HttpStatus.OK);
	}

	@GetMapping(path = "/needyPeople/getAll")
	public ResponseEntity<List<NeedyPeople>> getAllNeedyPeople() {
		return new ResponseEntity<List<NeedyPeople>>(empService.findAllNeedyPeople(), HttpStatus.OK);
	}
}
