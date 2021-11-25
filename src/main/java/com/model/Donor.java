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
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="donor")
public class Donor implements Serializable{
	@Id
	@GeneratedValue
	@Column(name="donor_id")
	private int donorId;
	@NotNull
	@Size(min=3,message="First Name should have atleast 3 characters")
	@Column(name="donor_name")
	private String donorName;
	@NotNull
	@Email
	@Column(name="donor_email",unique=true)
	private String donorEmail;
	@NotNull
	@Column(name="donor_phone")
	private String donorPhone;
	@NotNull
	@Column(name="donor_username")
	private String donorUsername;
	@NotNull
	@Size(min=8,message="password should have atleast 8 characters")
	@Column(name="donor_password")
	private String donorPassword;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="address_id")
	private Address address;
	
//	@OneToOne(cascade=CascadeType.ALL,mappedBy="donor")
//	private Donation donation;
	
	public Donor(String donorUsername2, String donorPassword2) {
		this.donorUsername=donorUsername;
		this.donorPassword=donorPassword;
	}
	public int getDonorId() {
		return donorId;
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((donorEmail == null) ? 0 : donorEmail.hashCode());
		result = prime * result + donorId;
		result = prime * result + ((donorName == null) ? 0 : donorName.hashCode());
		result = prime * result + ((donorPassword == null) ? 0 : donorPassword.hashCode());
		result = prime * result + ((donorPhone == null) ? 0 : donorPhone.hashCode());
		result = prime * result + ((donorUsername == null) ? 0 : donorUsername.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Donor other = (Donor) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (donorEmail == null) {
			if (other.donorEmail != null)
				return false;
		} else if (!donorEmail.equals(other.donorEmail))
			return false;
		if (donorId != other.donorId)
			return false;
		if (donorName == null) {
			if (other.donorName != null)
				return false;
		} else if (!donorName.equals(other.donorName))
			return false;
		if (donorPassword == null) {
			if (other.donorPassword != null)
				return false;
		} else if (!donorPassword.equals(other.donorPassword))
			return false;
		if (donorPhone == null) {
			if (other.donorPhone != null)
				return false;
		} else if (!donorPhone.equals(other.donorPhone))
			return false;
		if (donorUsername == null) {
			if (other.donorUsername != null)
				return false;
		} else if (!donorUsername.equals(other.donorUsername))
			return false;
		return true;
	}

}
