package com.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.model.DonationDistribution;
import com.model.Employee;
import com.model.NeedyPeople;
@Repository
public interface IEmployeeRepository extends JpaRepository<NeedyPeople, Integer>{

	 @Query(value="Select phone from NeedyPeople needyPeople",nativeQuery = true)
	boolean checkIfUserAlreadyExists(String phone);

}
