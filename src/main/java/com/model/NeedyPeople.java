package com.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="needy_people")
public class NeedyPeople {
	@Id
	@GeneratedValue
	@Column(name="needy_person_id")
	private int needyPersonId;
	@Column(name="needy_person_name")
	private String needyPersonName;
	private String phone;
	@Column(name="family_income")
	private double familyIncome;
	
	@OneToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="address_id")
	private Address address;
	
//	@OneToOne(cascade=CascadeType.ALL,mappedBy="needyPeople")
//	private DonationDistribution donationDistribution;

	public int getNeedyPersonId() {
		return needyPersonId;
	}
	public void setNeedyPersonId(int needyPersonId) {
		this.needyPersonId = needyPersonId;
	}
	public String getNeedyPersonName() {
		return needyPersonName;
	}
	public void setNeedyPersonName(String needyPersonName) {
		this.needyPersonName = needyPersonName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public double getFamilyIncome() {
		return familyIncome;
	}
	public void setFamilyIncome(double familyIncome) {
		this.familyIncome = familyIncome;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "NeedyPeople [needyPersonId=" + needyPersonId + ", needyPersonName=" + needyPersonName + ", phone="
				+ phone + ", familyIncome=" + familyIncome + ", address=" + address + "]";
	}

}
