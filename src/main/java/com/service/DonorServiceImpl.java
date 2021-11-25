package com.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.DonationRepository;
import com.dao.IDonorRepository;
import com.exception.DuplicateDonorException;
import com.exception.NoSuchDonorException;
import com.model.Donation;
import com.model.Donor;

@Service
public class DonorServiceImpl implements IDonorService{

	@Autowired
	IDonorRepository donorRepo;
	
	@Autowired
	DonationRepository donationRepo;
	@Override
	public Donor registerDonor(Donor donor) throws DuplicateDonorException {
		
		Optional<Donor> optRecord = donorRepo.findUserExists(donor);
		if(optRecord.isPresent()){
		  return optRecord.get();
		}else{
			donorRepo.save(donor);
		}
//		String email= donorRepo.checkIfUserAlreadyExists(donor.getDonorEmail());
//		if(email == donor.getDonorEmail()){
//	            throw new DuplicateDonorException("User already exists for this email");
//	        }
//		else
//		{
//			return donorRepo.save(donor);
//		}
		return donor;
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
		System.out.println("click here for rest the password");
		
	}

}
