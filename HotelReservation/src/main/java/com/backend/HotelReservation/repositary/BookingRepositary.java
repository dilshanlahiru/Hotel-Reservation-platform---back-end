package com.backend.HotelReservation.repositary;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.backend.HotelReservation.entity.Booking;


@Repository
public interface BookingRepositary extends JpaRepository<Booking, Long>{
	
	@Query(value="SELECT COUNT(*) FROM booking_details b  WHERE b.arrival_date=?1 AND b.departure_date=?2 AND b.category=?3 AND b.size=?4", nativeQuery = true)
	int availableCount(Date aDate, Date dDate, String catogoty, String size);
}
