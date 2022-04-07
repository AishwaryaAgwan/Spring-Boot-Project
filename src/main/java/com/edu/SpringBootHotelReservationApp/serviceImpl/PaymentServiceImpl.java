package com.edu.SpringBootHotelReservationApp.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.edu.SpringBootHotelReservationApp.entity.Booking;
import com.edu.SpringBootHotelReservationApp.entity.Payment;

import com.edu.SpringBootHotelReservationApp.exception.ResourceNotFoundException;
import com.edu.SpringBootHotelReservationApp.repository.BookingRepository;
import com.edu.SpringBootHotelReservationApp.repository.PaymentRepository;

import com.edu.SpringBootHotelReservationApp.service.BookingService;
import com.edu.SpringBootHotelReservationApp.service.PaymentService;



@Service
public class PaymentServiceImpl  implements PaymentService{
	
	private PaymentRepository paymentRepository;
	
	public PaymentServiceImpl(PaymentRepository paymentRepository) {
		super();
		this.paymentRepository = paymentRepository;
	}
	
	@Override
	public Payment savePayment(Payment payment) {
		return paymentRepository.save(payment);
	}
	
	
	@Override
	public List<Payment>getAllPayment(){
		return paymentRepository.findAll();
	}
	
	@Override
	public Payment getPaymentById(long id) {
		Optional<Payment>payment = paymentRepository.findById(id);
		if(payment.isPresent()) {
			return payment.get();
		}
		else {
			throw new ResourceNotFoundException("Payment","Id",id);
			
		}
	}

	@Override
	public Payment updatePayment(Payment payment,long id) {
		Payment pay = new Payment();
		try {
			pay = paymentRepository.findById(id).orElseThrow(   ()->  new ResourceNotFoundException("Payment","Id",id));
		} catch(ResourceNotFoundException e) {
			e.printStackTrace();
		}
		
		pay.setRoomCharge(payment.getRoomCharge());
		pay.setPaymentDate(payment.getPaymentDate());
		pay.setCreditcardNo(payment.getCreditcardNo());
		paymentRepository.save(pay);
		return pay;
		

}

	@Override
	public List<Payment> getPaymentByRoomCharge(String roomCharge) {
		return paymentRepository.findPaymentByRoomCharge(roomCharge) ;
	}

	@Override
	public List<Payment> gePaymentByPaymentDate(String paymentDate) {
		return paymentRepository.findPaymentByPaymentDate(paymentDate);
	}

	@Override
	public List<Payment> gePaymentByCreditcardNo(String creditcardNo) {
		return paymentRepository.findPaymentByCreditcardNo(creditcardNo);
	}
	
	
}





