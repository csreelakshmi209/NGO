package com.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.AdminRepository;
import com.exception.DuplicateEmployeeException;
import com.exception.NoSuchEmployeeException;
import com.model.DonationDistribution;
import com.model.Employee;

@Service
public class AdminServiceImpl implements IAdminService {
	//employee services that was handled by the admin
	
	@Autowired
	AdminRepository adminRepo;

//implementation methods

	// add method for employee
	@Override
	public Employee addEmployee(Employee employee) throws DuplicateEmployeeException, SQLException {
		int id = employee.getEmployeeId();
		if (id == 0) {
			throw new DuplicateEmployeeException();
		} else {
			adminRepo.save(employee);
		}
		return employee;
	}

	// get all employees data
	@Override
	public List<Employee> getEmployees() {
		List<Employee> e = adminRepo.findAll();

		return e;
	}

	// update the employee details

	@Override
	public Employee modifyEmployee(Employee employee) throws Throwable {
		int id = employee.getEmployeeId();
		Supplier s1 = () -> new NoSuchEmployeeException("Employee Does not exist in the database");
		Employee emp = adminRepo.findById(id).orElseThrow(s1);

		emp.setEmployeeName(emp.getEmployeeName());
		emp.setPhone(emp.getPhone());
		adminRepo.save(emp);

		return emp;
	}

	// remove the employee data
	@Override
	public String removeEmployee(int employeeId) throws NoSuchEmployeeException {
		if (employeeId != 0)
			adminRepo.deleteById(employeeId);

		else
			throw new NoSuchEmployeeException("Employee is not there in database");
		return "deleted";

	}

	// find employee by using id
	@Override
	public Employee findEmployeeById(int employeeId) throws NoSuchEmployeeException {
		Optional<Employee> optional = adminRepo.findById(employeeId);
		Employee emp = optional.get();
		if (optional.isPresent()) {
			adminRepo.getById(employeeId);
			return emp;
		} else
			throw new NoSuchEmployeeException("No Such Employee Found");

	}

	// find employee by using name
	@Override
	public Employee findEmployeeByName(String name) throws NoSuchEmployeeException {
		Employee e = adminRepo.findByEmployeeName(name);
		return e;

	}

	// final check to approve donation
	@Override
	public boolean approveDonation(DonationDistribution distribution) {
		System.out.println("donation was approved");
		return false;
	}

}
