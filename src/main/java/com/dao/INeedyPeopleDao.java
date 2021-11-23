package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.NeedyPeople;
@Repository
public interface INeedyPeopleDao extends JpaRepository<NeedyPeople, Integer>{
//	public int createNeedyPerson(NeedyPeople person);
//	public boolean readLoginData(NeedyPeople person);
//	public boolean requestForHelp(NeedyPeople person);

}
