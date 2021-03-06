package com.service;

import com.exception.DuplicateDonorException;
import com.exception.NoSuchDonorException;
import com.model.Donation;
import com.model.Donor;

public interface IDonorService {
	public Donor registerDonor(Donor donor) throws DuplicateDonorException;
	public Donor login(Donor donor) throws NoSuchDonorException;
	public Donation donateToNGO(Donation donation);
	public void sendThankyouMailToDonator(Donor donor);
	public String forgotPassword(String username,String password);
	
	public void emailPasswordToDonor(String email);
	public String resetPassword(String username, String password);

}
