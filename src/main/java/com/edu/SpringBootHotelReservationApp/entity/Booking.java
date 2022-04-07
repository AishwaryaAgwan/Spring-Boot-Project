package com.edu.SpringBootHotelReservationApp.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
//import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="bookingTbl")
public class Booking {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column
	private long id;
	@Column(name="booking_date")
	private String bookingDate;
	@Column(name="booking_time")
	private String bookingTime;
	@Column(name="num_adults")
	private String numAdults;
	@Column(name="num_childern")
	private String numChildren;
	
	
	@ManyToOne
	@JoinTable(name="booking_user",joinColumns = { @JoinColumn(name = "hotel_id")},inverseJoinColumns = {@JoinColumn(name="user_id")})
	private Hotel hotelId;
	
	
	
	
	public Booking(long id, String bookingDate, String bookingTime, String numAdults, String numChildren,
			Hotel hotelId) {
		super();
		this.id = id;
		this.bookingDate = bookingDate;
		this.bookingTime = bookingTime;
		this.numAdults = numAdults;
		this.numChildren = numChildren;
		this.hotelId = hotelId;
	}
	public Booking() {
		
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}
	public String getBookingTime() {
		return bookingTime;
	}
	public void setBookingTime(String bookingTime) {
		this.bookingTime = bookingTime;
	}
	public String getNumAdults() {
		return numAdults;
	}
	public void setNumAdults(String numAdults) {
		this.numAdults = numAdults;
	}
	public String getNumChildren() {
		return numChildren;
	}
	public void setNumChildren(String numChildren) {
		this.numChildren = numChildren;
	}
	public Hotel getHotel() {
		return hotelId;
	}
	public void setHotel(Hotel hotelId) {
		this.hotelId = hotelId;
	}
	
	



}
