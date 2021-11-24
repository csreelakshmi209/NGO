package com.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.INeedyPeopleRepository;
import com.exception.NoSuchDonorException;
import com.exception.NoSuchNeedyPeopleException;
import com.model.Donor;
import com.model.NeedyPeople;

@Service
public class NeedypeopleServiceImpl implements INeedyPeopleService{

	@Autowired
	INeedyPeopleRepository needyPeopleDao;
	
	@Override
	public NeedyPeople registerNeedyPerson(NeedyPeople person) throws NoSuchNeedyPeopleException {
		String num=needyPeopleDao.checkIfUserAlreadyExists(person.getPhone());
		if(num == person.getPhone() )
		{
			throw new NoSuchNeedyPeopleException("User already exists for this phone");
		}
		else
		{
			return needyPeopleDao.save(person);
		}
	}

	@Override
	public NeedyPeople login(NeedyPeople person) throws NoSuchNeedyPeopleException, NoSuchDonorException{
		
		NeedyPeople needid=needyPeopleDao.findById(person.getNeedyPersonId()).orElse(null);
		if(needid==null) {
			String NoSuchNeedyPeople="No needy found by the needy id"+person.getNeedyPersonId();
			throw new NoSuchNeedyPeopleException("no such needy person");
		}
		else {
			if(person.getNeedyPersonName().equals(needid.getNeedyPersonName()) && person.getPhone().equals(needid.getPhone())){
				return needid;
			}
			else {
				throw new NoSuchDonorException("Donor username and password are invalid");
			}
		}	
	}

	@Override
	public boolean requestForHelp(NeedyPeople person) {
		System.out.println("send your request through mail box");
		return false;
	}

}
