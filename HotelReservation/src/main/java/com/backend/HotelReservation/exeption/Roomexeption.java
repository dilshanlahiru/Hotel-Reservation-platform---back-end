package com.backend.HotelReservation.exeption;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class Roomexeption extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Roomexeption(String message) {
		super(message);
	}

}
