package com.edu.SpringBootHotelReservationApp.service;

import java.util.List;

import com.edu.SpringBootHotelReservationApp.entity.Admin;

public interface AdminService {
	
	
	List<Admin> getAllAdmin();
	Admin getAdminById(long id);
	Admin saveAdmin(Admin admin);
	Admin updateAdmin(Admin admin, long id);
}
