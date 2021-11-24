package com.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.EmployeeRepository;
import com.dao.IAdminRepository;
import com.exception.DuplicateEmployeeException;
import com.exception.NoSuchEmployeeException;
import com.model.DonationDistribution;
import com.model.Employee;

@Service
public class AdminServiceImpl implements IAdminService {
		@Autowired
	IAdminRepository adminDao;
		
	@Autowired
	EmployeeRepository empDao;
	
	Employee employee;
	
	@Override
	public Employee addEmployee(Employee emp)  {
		
		emp=empDao.save(employee);
		
//		String email= adminDao.checkIfUserAlreadyExists(employee.getEmail());
//		
//		if(email==emp.getEmail())
//		{
//			throw new NoSuchEmployeeException("no employee");
//		}
//		else
//		{
//			emp=adminDao.save(employee);
//		}
		return emp;	
	}
	
	@Override
	public List<Employee> getEmployees()
	{
		List<Employee> lc1=empDao.findAll();
		
		return lc1;
	}

	@Override
	public Employee modifyEmployee(Employee employee) throws Throwable {
		int id=employee.getEmployeeId();
		Supplier s1= ()->new NoSuchEmployeeException("Employee Does not exist in the database");
		Employee emp=empDao.findById(id).orElseThrow(s1);
		
		emp.setEmployeeName(emp.getEmployeeName());
		emp.setPhone(emp.getPhone());
		empDao.save(emp);
			
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
	public List<Employee> findEmployeeById(int employeeId) throws NoSuchEmployeeException {
		Optional<Employee> optional=empDao.findById(employeeId);
		Employee emp=optional.get();
		if(optional.isPresent())
		{
			adminDao.getById(employeeId);
			return (List<Employee>) emp;
		}
		else
			throw new NoSuchEmployeeException("employee doesnt found");
		
	}

	@Override
	public List<Employee> findEmployeeByName(String name) throws NoSuchEmployeeException {
		
		return adminDao.findmployeeByName(name);
		
	}

	@Override
	public List<Employee> findAllEmployee() throws NoSuchEmployeeException {
		
		return empDao.findAll();
	}

	@Override
	public boolean approveDonation(DonationDistribution distribution) {
		System.out.println("donation was approved");
		return false;
	}

	


}
