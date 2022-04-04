package com.edu.SpringBootHotelReservationApp.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.edu.SpringBootHotelReservationApp.entity.Admin;
import com.edu.SpringBootHotelReservationApp.exception.ResourceNotFoundException;
import com.edu.SpringBootHotelReservationApp.repository.AdminRepository;
import com.edu.SpringBootHotelReservationApp.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService{

	private AdminRepository adminRepository;
	
	
	public AdminServiceImpl(AdminRepository adminRepository) {
		super();
		this.adminRepository = adminRepository;
	}


	@Override
	public Admin saveAdmin(Admin admin) {
		return adminRepository.save(admin);
	}


	@Override
	public List<Admin> getAllAdmin() {
		return adminRepository.findAll();
		
	}


	@Override
	public Admin getAdminById(long id) {
		Optional<Admin> admin = adminRepository.findById(id);
		if(admin.isPresent()) {
			return admin.get();
		}
		else {
          
			throw new ResourceNotFoundException("Admin","Id",id);
		}
		
	}


	@Override
	public Admin updateAdmin(Admin admin, long id) {
		Admin admin1 = new Admin();
	 try {
		 admin1 = adminRepository.findById(id).orElseThrow(
				 ()-> 		 new ResourceNotFoundException("Admin","Id",id));
	} catch (ResourceNotFoundException e) {
		
		e.printStackTrace();
	}
	 admin1.setFirstName(admin.getFirstName());
	 admin1.setLastName(admin.getLastName());
	 admin1.setHotelName(admin.getHotelName());
	 admin1.setCurUser(admin.getCurUser());
	 admin1.setPhone(admin.getPhone());
	 admin1.setDate(admin.getDate());
	 
	 adminRepository.save(admin1);
	return admin1;
	}


	public AdminRepository getEmployeeRepository() {
		return adminRepository;
	}


	public void setBookingRepository(AdminRepository adminRepository) {
		this.adminRepository = adminRepository;
	}


	

}
