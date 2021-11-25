package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.model.Donor;

public interface DonorRepository extends JpaRepository<Donor, Integer> {

	 @Query(value="Select donor_email from donor",nativeQuery = true)
	 String checkIfUserAlreadyExists(String donorEmail);

}
