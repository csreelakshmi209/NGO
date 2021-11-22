package com.dao;

import java.sql.SQLException;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.Donation;
import com.model.Donor;

@Repository
public interface IDonorDao extends JpaRepository<Donor,Integer>{
	public int createDonor(Donor donor) throws SQLException;
	public int login(Donor donor) throws SQLException;
	public Donation donateToNGO(Donation donation);
	public String forgotPassword(String username);
	public String resetPassword(String username);

	
}
