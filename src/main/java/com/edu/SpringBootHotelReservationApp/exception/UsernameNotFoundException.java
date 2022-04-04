package com.edu.SpringBootHotelReservationApp.exception;



import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
/**
 * 
 */
@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class UsernameNotFoundException extends RuntimeException{
     
	private static final long serialVersionUID = 1L;
	private String userName;
     private String fieldName;
     private Object fieldValue;
	public  UsernameNotFoundException(String userName, String fieldName, Object fieldValue) {
		super(String.format("%s not found with %s : %s", userName, fieldName, fieldValue));
		this.userName = userName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}
	
	public String getResourceName() {
		return userName;
	}
	
	public String getFieldName() {
		return fieldName;
	}
	
	public Object getFieldValue() {
		return fieldValue;
	}
     
     
}
