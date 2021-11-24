package com.dao;

import java.sql.SQLException;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.model.Donation;
import com.model.Donor;
import com.model.Employee;

@Repository
public interface IDonorRepository extends JpaRepository<Donor,Integer>{

	 //findByEmail(String email);
//	public int createDonor(Donor donor) throws SQLException;
//	public int login(Donor donor) throws SQLException;
//	public Donation donateToNGO(Donation donation);
//	public String forgotPassword(String username);
//	public String resetPassword(String username);

	 @Query(value="Select donor_email from donor",nativeQuery = true)
	 String checkIfUserAlreadyExists(String donorEmail);
//	 @Query(value="select donor_username,donor_password from donor",nativeQuery = true)
//	 String checkLoginDetails(String username,String password);

	

	
}