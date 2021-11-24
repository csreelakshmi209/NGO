package com.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.DonationDao;
import com.dao.IDonorDao;
import com.exception.DuplicateDonorException;
import com.exception.NoSuchDonorException;
import com.model.Donation;
import com.model.Donor;

@Service
public class DonorServiceImpl implements IDonorService{

	@Autowired
	IDonorDao donorDao;
	
	@Autowired
	DonationDao donationDao;
	@Override
	public Donor registerDonor(Donor donor) throws DuplicateDonorException {
		String email= donorDao.checkIfUserAlreadyExists(donor.getDonorEmail());
		if(email == donor.getDonorEmail()){
	            throw new DuplicateDonorException("User already exists for this email");
	        }
		else
		{
			return donorDao.save(donor);
		}
	    }
	@Override
	public Donor login(Donor donor) throws NoSuchDonorException {
		Donor doid=donorDao.findById(donor.getDonorId()).orElse(null);
		if(doid==null) {
			String NoSuchDonor="No Donor found by the donor id"+donor.getDonorId();
			throw new  NoSuchDonorException("NoSuchDonor");
		}
		else {
			if(donor.getDonorUsername().equals(doid.getDonorUsername()) && donor.getDonorPassword().equals(doid.getDonorPassword())){
				return doid;
			}
			else {
				throw new NoSuchDonorException("Donor username and password are invalid");
			}
		}	
		
	}

	@Override
	public Donation donateToNGO(Donation donation) {
		
		return donationDao.save(donation);
	}

	@Override
	public void sendThankyouMailToDonator(Donor donor) {
		System.out.println("Thankyou for donating");
		
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
