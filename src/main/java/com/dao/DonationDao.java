package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.Donation;

public interface DonationDao extends JpaRepository<Donation, Integer> {

}
