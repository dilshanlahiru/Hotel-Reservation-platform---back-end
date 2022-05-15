package com.backend.HotelReservation.entity;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bookingDetails")
public class Booking {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "bookingId")
	private long bookingId;
	
	@Column(name = "customerId")
	private long customerId;
	
	@Column(name = "category")
	private String category;
	
	@Column(name = "size")
	private String size;
	
	@Column(name = "arrivalDate")
	private Date arrivalDate;
	
	@Column(name = "departureDate")
	private Date departureDate;
	
	public Booking() {
		
	}

	public Booking(long bookingId, long customerId, String category, String size, Date arrivalDate,
			Date departureDate) {
		super();
		this.bookingId = bookingId;
		this.customerId = customerId;
		this.category = category;
		this.size = size;
		this.arrivalDate = arrivalDate;
		this.departureDate = departureDate;
	}

	public long getBookingId() {
		return bookingId;
	}

	public void setBookingId(long bookingId) {
		this.bookingId = bookingId;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public Date getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public Date getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(arrivalDate, bookingId, category, customerId, departureDate, size);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Booking other = (Booking) obj;
		return Objects.equals(arrivalDate, other.arrivalDate) && bookingId == other.bookingId
				&& Objects.equals(category, other.category) && customerId == other.customerId
				&& Objects.equals(departureDate, other.departureDate) && Objects.equals(size, other.size);
	}


	
	
}
