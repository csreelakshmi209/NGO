package com.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="donor")
public class Donor implements Serializable{
	@Id
	@GeneratedValue
	@Column(name="donor_id")
	private int donorId;
	@Column(name="donor_name")
	private String donorName;
	@Column(name="donor_email",unique=true)
	private String donorEmail;
	@Column(name="donor_phone")
	private String donorPhone;
	@Column(name="donor_username")
	private String donorUsername;
	@Column(name="donor_password")
	private String donorPassword;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="address_id")
	private Address address;
	
//	@OneToOne(cascade=CascadeType.ALL,mappedBy="donor")
//	private Donation donation;
	
	public Donor() {}
	public int getDonorId() {
		return donorId;
	}
	public Donor(int donorId, String donorName, String donorEmail, String donorPhone, String donorUsername,
		String donorPassword, Address address) {
	super();
	this.donorId = donorId;
	this.donorName = donorName;
	this.donorEmail = donorEmail;
	this.donorPhone = donorPhone;
	this.donorUsername = donorUsername;
	this.donorPassword = donorPassword;
	this.address = address;
}
	public void setDonorId(int donorId) {
		this.donorId = donorId;
	}
	public String getDonorName() {
		return donorName;
	}
	public void setDonorName(String donorName) {
		this.donorName = donorName;
	}
	public String getDonorEmail() {
		return donorEmail;
	}
	public void setDonorEmail(String donorEmail) {
		this.donorEmail = donorEmail;
	}
	public String getDonorPhone() {
		return donorPhone;
	}
	public void setDonorPhone(String donorPhone) {
		this.donorPhone = donorPhone;
	}
	public String getDonorUsername() {
		return donorUsername;
	}
	public void setDonorUsername(String donorUsername) {
		this.donorUsername = donorUsername;
	}
	public String getDonorPassword() {
		return donorPassword;
	}
	public void setDonorPassword(String donorPassword) {
		this.donorPassword = donorPassword;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Donor [donorId=" + donorId + ", donorName=" + donorName + ", donorEmail=" + donorEmail + ", donorPhone="
				+ donorPhone + ", donorUsername=" + donorUsername + ", donorPassword=" + donorPassword + ", address="
				+ address + "]";
	}

}
