package com.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.IAdminDao;
import com.exception.DuplicateEmployeeException;
import com.exception.NoSuchEmployeeException;

import com.model.DonationDistribution;
import com.model.Employee;

@Service
public class AdminServiceImpl implements IAdminService {
		@Autowired
	IAdminDao adminDao;
	
	Employee emp;
	
	@Override
	public Employee addEmployee(Employee employee) throws DuplicateEmployeeException, SQLException {
		int id=employee.getEmployeeId();
		if(id!=0)
		{
			throw new DuplicateEmployeeException();
		}
		else
		{
			emp=adminDao.save(employee);
		}
		return emp;	
	}

	@Override
	public Employee modifyEmployee(Employee employee) throws Throwable {
		int id=employee.getEmployeeId();
		Supplier s1= ()->new NoSuchEmployeeException("Employee Does not exist in the database");
		Employee emp=adminDao.findById(id).orElseThrow(s1);
		
		emp.setEmployeeName(emp.getEmployeeName());
		emp.setPhone(emp.getPhone());
		adminDao.save(emp);
			
		return emp;
		
	}

	@Override
	public String removeEmployee(int employeeId) throws NoSuchEmployeeException {
		if(employeeId!=0)
		adminDao.deleteById(employeeId);
		
		else
			throw new NoSuchEmployeeException("Employee is not there in database");
		return "deleted";
		
	}

	@Override
	public Employee findEmployeeById(int employeeId) throws NoSuchEmployeeException {
		Optional<Employee> optional=adminDao.findById(employeeId);
//		Employee emp=optional.get();
//		if(optional.isPresent())
//		{
//			adminDao.getById(employeeId);
//			return emp;
//		}
		return optional.get();
		
	}

	@Override
	public List<Employee> findEmployeeByName(String name) throws NoSuchEmployeeException {
		
		//return adminDao.findmployeeByName(name);
		return null;
	}

	@Override
	public List<Employee> findAllEmployee() throws NoSuchEmployeeException {
		
		return adminDao.findAll();
	}

	@Override
	public boolean approveDonation(DonationDistribution distribution) {
		System.out.println();
		return false;
	}

}
