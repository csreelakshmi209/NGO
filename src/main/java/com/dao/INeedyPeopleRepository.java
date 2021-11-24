package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.model.NeedyPeople;
@Repository
public interface INeedyPeopleRepository extends JpaRepository<NeedyPeople, Integer>{

	 @Query(value="Select phone from needy_people",nativeQuery = true)
	 String checkIfUserAlreadyExists(String phone);

	
//	public int createNeedyPerson(NeedyPeople person);
//	public boolean readLoginData(NeedyPeople person);
//	public boolean requestForHelp(NeedyPeople person);

}
