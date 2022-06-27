package com.rest.api.user.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.NonNull;

@Entity
@Table(name = "user_address")
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class UserAddress implements Serializable {
	private static final long serialVersionUID = -3570928575182329616L;

	@ManyToOne()
	@JoinColumn(name = "user_id")
	private UserData userdata;

	@Id
	@Column(name = "addr_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long addrid;

	@Column(name = "dr_no")
	@NonNull
	private String doorNo;

	@Column(name = "strt_name")
	@NonNull
	private String streetName;

	@Column(name = "city")
	@NonNull
	private String city;

	@Column(name = "country")
	@NonNull
	private String country;

	public UserData getUserdata() {
		return userdata;
	}

	public void setUserdata(UserData userdata) {
		this.userdata = userdata;
	}

	public Long getAddrid() {
		return addrid;
	}

	public void setAddrid(Long addrid) {
		this.addrid = addrid;
	}

	public String getDoorNo() {
		return doorNo;
	}

	public void setDoorNo(String doorNo) {
		this.doorNo = doorNo;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "UserAddress [userdata=" + userdata + ", addrid=" + addrid + ", doorNo=" + doorNo + ", streetName="
				+ streetName + ", city=" + city + ", country=" + country + "]";
	}

}