package com.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.DonationRepository;
import com.dao.DonorRepository;
import com.exception.DuplicateDonorException;
import com.exception.NoSuchDonorException;
import com.model.Donation;
import com.model.Donor;

@Service
public class DonorServiceImpl implements IDonorService{

	@Autowired
	DonorRepository donorRepo;
	
	@Autowired
	DonationRepository donationRepo;
	
	Donor donor = null;
	@Override
	public Donor registerDonor(Donor donor) throws DuplicateDonorException {
		
		String email= donorRepo.checkIfUserAlreadyExists(donor.getDonorEmail());
		if(email == donor.getDonorEmail()){
	            throw new DuplicateDonorException("User already exists for this email");
	        }
		else
		{
			return donorRepo.save(donor);
		}
	    }
	@Override
	public Donor login(Donor donor) throws NoSuchDonorException {
		Donor doid=donorRepo.findById(donor.getDonorId()).orElse(null);
		if(doid==null) {
			String NoSuchDonor="No Donor found by the donor id"+donor.getDonorId();
			throw new  NoSuchDonorException(NoSuchDonor);
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
		
		return donationRepo.save(donation);
	}

	@Override
	public void sendThankyouMailToDonator(Donor donor) {
		System.out.println("Thankyou for donating");
		
	}

	@Override
	public String forgotPassword(String username,String password) {
		
		if(donor.getDonorUsername().equals(username))
		{
			if(!donor.getDonorPassword().equals(password))
			{
				System.out.println("your password is not correct try to reset your password");
				return password;
			}
		}
		
		return username;
	}

	@Override
	public String resetPassword(String username,String password) {
	   if(donor.getDonorUsername().equals(username))
	   {
		   System.out.println("click here to reset your password");
		   donor.setDonorPassword(password);	   
		   }
		return username;
	}

	@Override
	public void emailPasswordToDonor(String email) {
		System.out.println("click here get your the password");
		
	}

}
