package com.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.dao.IAdminDao;
import com.exception.DuplicateEmployeeException;
import com.exception.NoSuchEmployeeException;
import com.model.DonationDistribution;
import com.model.Employee;

import ch.qos.logback.classic.Logger;

public class AdminServiceImpl implements IAdminService {

	@Autowired
	IAdminDao adminDao;
	
	@Override
	public boolean addEmployee(Employee employee) throws DuplicateEmployeeException, SQLException {
		if(employee.getEmployeeName().isEmpty() || employee.getEmployeeId() ==0)
		{
			 throw new DuplicateEmployeeException();
		}
		else
		{
			Employee saveEmp=adminDao.save(employee);
		}
		return false;
		
	}

	@Override
	public Employee modifyEmployee(Employee employee) throws NoSuchEmployeeException {
		// TODO Auto-generated method stub
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
