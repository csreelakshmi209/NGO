package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.IEmployeeDao;
import com.exception.NoSuchEmployeeException;
import com.exception.NoSuchNeedyPeopleException;
import com.model.DonationDistribution;
import com.model.Employee;
import com.model.NeedyPeople;

@Service
public class EmployeeServiceImpl implements IEmployeeService{

	@Autowired
	IEmployeeDao empDao;
	@Override
	public Employee login(Employee employee) throws NoSuchEmployeeException {
		if(empDao.checkIfUserAlreadyExists(employee.getPhone()))
		{
			throw new NoSuchEmployeeException("User already exists for this phone");
		}
		else
		{
			return empDao.save(employee);
		}
		
	}

	@Override
	public NeedyPeople addNeedyPerson(NeedyPeople person) {
		
		
		return empDao.save(person);
	}

	@Override
	public boolean removeNeedyPerson(NeedyPeople person) {
		
		return false;
	}

	@Override
	public NeedyPeople findNeedyPeopleById(int id) {
//		Optional<Employee> optional=empDao.findById(id);
//		Employee emp=optional.get();
//		if(optional.isPresent())
//		{
//			adminDao.getById(employeeId);
//			return (List<Employee>) emp;
//		}
//		else
//			throw new NoSuchEmployeeException("employee doesnt found");
//		
		return null;
	}

	@Override
	public List<NeedyPeople> findNeedyPeopleByName(String name) {
		
		return null;
	}

	@Override
	public List<NeedyPeople> findAllNeedyPeople() {
		
		return null;
	}

	@Override
	public String helpNeedyPerson(DonationDistribution distribute) {
		
		return null;
	}

}
