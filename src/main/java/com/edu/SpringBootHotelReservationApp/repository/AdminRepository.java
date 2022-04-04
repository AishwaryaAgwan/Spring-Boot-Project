package com.edu.SpringBootHotelReservationApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edu.SpringBootHotelReservationApp.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin,Long>{

}
