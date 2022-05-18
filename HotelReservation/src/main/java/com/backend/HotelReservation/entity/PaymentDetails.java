package com.backend.HotelReservation.entity;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "paymentDetails")
public class PaymentDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "paymentId")
	private long paymentId;
	
	@Column(name = "bookingId")
	private long bookingId;
	
	@Column(name = "price")
	private double price;
	
	public PaymentDetails () {
		
	}

	public PaymentDetails(long paymentId, long bookingId, double price) {
		super();
		this.paymentId = paymentId;
		this.bookingId = bookingId;
		this.price = price;
	}

	public long getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(long paymentId) {
		this.paymentId = paymentId;
	}

	public long getBookingId() {
		return bookingId;
	}

	public void setBookingId(long bookingId) {
		this.bookingId = bookingId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(bookingId, paymentId, price);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PaymentDetails other = (PaymentDetails) obj;
		return bookingId == other.bookingId && paymentId == other.paymentId
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price);
	}
	
	

}
