package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.INeedyPeopleDao;
import com.model.NeedyPeople;

@Service
public class NeedypeopleServiceImpl implements INeedyPeopleService{

	@Autowired
	INeedyPeopleDao needyPeopleDao;
	@Override
	public boolean registerNeedyPerson(NeedyPeople person) {
		
		return false;
	}

	@Override
	public boolean login(NeedyPeople person) {
		
		return false;
	}

	@Override
	public boolean requestForHelp(NeedyPeople person) {
		
		return false;
	}

}
