package com.edu.SpringBootHotelReservationApp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.Data;

@Data
@Entity
@Table(name="adminTbl")

public class Admin{
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)

    @Column
	private Long id;
	@Column(name="firstName")
	private String firstName;
	
	@Column(name="lastName")
	private String lastName;
	
	@Column(name="hotelName")
	private String hotelName;
	
	@Column(name="curUser")
	private String curUser;
	
	@Column(name="phone")
	private String phone;
	
	@Column(name="date")
	private String date;

	

	public Admin() {
	}
	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Object getFirstName() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setFirstName(Object firstName2) {
		// TODO Auto-generated method stub
		
	}

	
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getCurUser() {
		return curUser;
	}

	public void setCurUser(String curUser) {
		this.curUser = curUser;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
}

