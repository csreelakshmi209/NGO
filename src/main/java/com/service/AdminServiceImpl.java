package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.dao.AdminDao;
import com.exception.DuplicateEmployeeException;
import com.exception.NoSuchEmployeeException;
import com.model.DonationDistribution;
import com.model.Employee;

public class AdminServiceImpl implements IAdminService{

	@Autowired
	AdminDao adminDao;
	
	@Override
	public boolean addEmployee(Employee employee) throws DuplicateEmployeeException {
		
		return false;
	}

	@Override
	public Employee modifyEmployee(Employee employee) throws NoSuchEmployeeException {
		
		return null;
	}

	@Override
	public boolean removeEmployee(int employeeId) throws NoSuchEmployeeException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Employee findEmployeeById(int employeeId) throws NoSuchEmployeeException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> findEmployeeByName(String name) throws NoSuchEmployeeException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> findAllEmployee() throws NoSuchEmployeeException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean approveDonation(DonationDistribution distribution) {
		// TODO Auto-generated method stub
		return false;
	}

}
