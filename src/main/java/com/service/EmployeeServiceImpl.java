package com.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.AdminRepository;
import com.dao.EmployeeRepository;
import com.dao.IEmployeeRepository;
import com.dao.INeedyPeopleRepository;
import com.dao.NeedyPeopleRepository;
import com.exception.NoSuchEmployeeException;
import com.exception.NoSuchNeedyPeopleException;
import com.model.DonationDistribution;
import com.model.Employee;
import com.model.NeedyPeople;

@Service
public class EmployeeServiceImpl implements IEmployeeService{

	@Autowired
	 EmployeeRepository empRepo;
	
	@Autowired
	 IEmployeeRepository empDao;
	
	@Autowired
	NeedyPeopleRepository needyRepo;
	@Override
	public Employee login(Employee employee) throws NoSuchEmployeeException,SQLException {
		Employee emp=empRepo.findById(employee.getEmployeeId()).orElse(null);
		if(emp==null) {
			String noSuchEmployee="No Donor found by the donor id"+employee.getEmployeeId();
			throw new  NoSuchEmployeeException(noSuchEmployee);
		}
		else {
			if(employee.getUsername().equals(emp.getUsername()) && employee.getPassword().equals(emp.getPassword())){
				return emp;
			}
			else {
				throw new NoSuchEmployeeException("Employee username and password are invalid");
			}
		}	
		
	}

	@Override
	public NeedyPeople addNeedyPerson(NeedyPeople person) {
		needyRepo.save(person);
			
		return person;
	}

	@Override
	public boolean removeNeedyPerson(NeedyPeople person) {
		needyRepo.delete(person);
		return true;
		
	}

	@Override
	public NeedyPeople findNeedyPeopleById(int id) {
		NeedyPeople n=needyRepo.findById(id).get();
		return n;
			}

	@Override
	public List<NeedyPeople> findNeedyPeopleByName(String name) {
		
		return needyRepo.findAll();
		//return empRepo.findAll();
		
	}



	@Override
	public String helpNeedyPerson(DonationDistribution distribute) {
		
		return null;
	}

	@Override
	public List<NeedyPeople> findAllNeedyPeople() {
		List<NeedyPeople> n=needyRepo.findAll();
		return n;
	}

	

}
