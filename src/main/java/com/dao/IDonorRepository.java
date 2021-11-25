package com.dao;

import java.sql.SQLException;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.model.Donation;
import com.model.Donor;
import com.model.Employee;

@Repository
public interface IDonorRepository extends JpaRepository<Donor,Integer>{


//	 @Query(value="Select donor_email from donor",nativeQuery = true)
//	 String checkIfUserAlreadyExists(String donorEmail);
//	 @Query(value="select donor_username,donor_password from donor",nativeQuery = true)
//	 String checkLoginDetails(String username,String password);
	 @Query("select donor_email from donor")
	Optional<Donor> findUserExists(@Param("d") Donor d);

	

	
}