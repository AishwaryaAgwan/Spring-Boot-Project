package com.edu.SpringBootHotelReservationApp.service;

import java.util.List;

import com.edu.SpringBootHotelReservationApp.entity.Payment;





public interface PaymentService {

	
	
	Payment savePayment(Payment payment);
	List<Payment>getAllPayment();
	Payment updatePayment(Payment payment,long id);
	Payment getPaymentById(long id);
	List<Payment> getPaymentByRoomCharge(String roomCharge);
	List<Payment> gePaymentByPaymentDate(String paymentDate);
	List<Payment> gePaymentByCreditcardNo(String creditcardNo);



}
