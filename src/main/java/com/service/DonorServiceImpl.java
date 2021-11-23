package com.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.IDonorDao;
import com.exception.DuplicateDonorException;
import com.exception.NoSuchDonorException;
import com.model.Donation;
import com.model.Donor;

@Service
public class DonorServiceImpl implements IDonorService{

	@Autowired
	IDonorDao donorDao;
	
	@Override
	public Donor registerDonor(Donor donor) throws DuplicateDonorException {
		
		if(donorDao.checkIfUserExist(donor.getDonorEmail())){
	            throw new DuplicateDonorException("User already exists for this email");
	        }
		else
		{
			return donorDao.save(donor);
		}
	    }
	@Override
	public boolean login(Donor donor) throws NoSuchDonorException {
		
		return false;
	}

	@Override
	public Donation donateToNGO(Donation donation) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void sendThankyouMailToDonator(Donor donor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String forgotPassword(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String resetPassword(String username) {
	   
		return username;
	}

	@Override
	public void emailPasswordToDonor(String email) {
		// TODO Auto-generated method stub
		
	}

}
