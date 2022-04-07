package com.edu.SpringBootHotelReservationApp.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Data;


@Data
@Entity
@Table(name="userTbl")
public class User {
	
	protected User(Long id, Hotel hotel) {
		super();
		this.id = id;
		this.hotel = hotel;
	}

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column
	private Long id;
	
	@Column
	@NotBlank(message="First Name can't be empty")
	private String firstName;
	@Column
	@NotBlank(message="Last Name can't be empty")
	private String lastName;
	@Column
	@NotBlank(message="Email can't be empty")
	private String email;
	//@Column(name="userName")
	private String userName;
	//@Column(name="password")
	private String password;
	
	@Column
	@NotBlank(message="Contact Number can't be empty")
	private String contactNo;
	@Column
	private String address;
	
	private boolean active;
	private String roles;
	
	@Transient
	private int count;

	@OneToOne
	@JoinColumn(name="hotel")
	private Hotel hotel;
	
	@ManyToOne
	@JoinTable(name="user_hotel", joinColumns= { @JoinColumn(name="user_id")}, inverseJoinColumns= { @JoinColumn(name="hotel_id")})

   private Admin admin;

	public User() {
	}

	public User(String firstName, String lastName) {
		super();
        this.firstName = firstName;
		this.lastName = lastName;
	}

	public User(Long id, String email) {
		super();
		this.id = id;
		this.email = email;
	}

	public User(int count, Hotel hotel) {
		super();
		this.count = count;
		this.hotel = hotel;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public String getRoles() {
		return roles;
	}
	public void setRoles(String roles) {
		this.roles = roles;
	}

	public User(long id, @NotBlank(message = "First name can't be Empty") String firstName,
			@NotBlank(message = "Last name can't be empty") String lastName,
			@NotBlank(message = "Email can't be empty") @Email String email,
			//@NotBlank(message = "Password can't be empty") String password,
			@NotBlank(message = "Contact Number can't be empty") String contactNo, String address)
			//List<Course> course)
	{
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		//this.password = password;
		this.contactNo = contactNo;
		//this.address = address;
		//this.course = course;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", contactNo=" + contactNo + "]";
	}

	
	
	
}