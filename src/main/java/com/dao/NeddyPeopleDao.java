package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.NeedyPeople;

public interface NeddyPeopleDao extends JpaRepository<NeedyPeople, Integer>{
	public int createNeedyPerson(NeedyPeople person);
	public boolean readLoginData(NeedyPeople person);
	public boolean requestForHelp(NeedyPeople person);

}
