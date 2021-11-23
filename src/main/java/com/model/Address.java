package com.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="address")
public class Address implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="address_id",nullable=false)
	private int addressId;
	private String city;
	private String state;
	private String pin;
	private String landmark;
	
//	@OneToOne(fetch =FetchType.LAZY,cascade=CascadeType.ALL,mappedBy="address")
//	private NeedyPeople needyPeople;
//	
//	@OneToOne(cascade=CascadeType.ALL,mappedBy="address")
//	private Employee employee;
//	
//	@OneToOne(cascade=CascadeType.ALL,mappedBy="address")
//	private Donor donor;
	
	
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	public String getLandmark() {
		return landmark;
	}
	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}
	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", city=" + city + ", state=" + state + ", pin=" + pin
				+ ", landmark=" + landmark + "]";
	}

	
}
