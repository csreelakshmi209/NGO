package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.IEmployeeDao;
import com.exception.NoSuchEmployeeException;
import com.model.DonationDistribution;
import com.model.Employee;
import com.model.NeedyPeople;

@Service
public class EmployeeServiceImpl implements IEmployeeService{

	@Autowired
	IEmployeeDao empDao;
	@Override
	public boolean login(Employee employee) throws NoSuchEmployeeException {
		
		return false;
	}

	@Override
	public NeedyPeople addNeedyPerson(NeedyPeople person) {
		
		return null;
	}

	@Override
	public boolean removeNeedyPerson(NeedyPeople person) {
		
		return false;
	}

	@Override
	public NeedyPeople findNeedyPeopleById(int id) {
		
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
