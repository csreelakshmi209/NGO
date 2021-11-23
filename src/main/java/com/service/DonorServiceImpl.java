package com.service;

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
	
	Donor donors;
	@Override
	public boolean registerDonor(Donor donor) throws DuplicateDonorException {
		if(emailExist(donor.getDonorEmail()))
		{
			throw new DuplicateDonorException();
		}
		return false;
	}

	private boolean emailExist(String donorEmail) {
		
		//donorDao.findByEmail(DonorEmail)!=null
		return false;
	}

	@Override
	public boolean login(Donor donor) throws NoSuchDonorException {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void emailPasswordToDonor(String email) {
		// TODO Auto-generated method stub
		
	}

}
