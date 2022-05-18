package com.backend.HotelReservation.repositary;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.backend.HotelReservation.entity.Booking;


@Repository
public interface BookingRepositary extends JpaRepository<Booking, Long>{
	
	@Query(value="SELECT COUNT(*) FROM booking_details b  WHERE b.arrival_date=?1 AND b.departure_date=?2 AND b.category=?3 AND b.size=?4", nativeQuery = true)
	int availableCount(Date aDate, Date dDate, String catogoty, String size);
	
	@Query(value="SELECT COUNT(*) FROM booking_details b  WHERE b.arrival_date LIKE %?1% AND b.departure_date LIKE %?2% AND b.category=?3 AND b.size=?4", nativeQuery = true)
	int availableCount4(String aDate, String dDate, String catogoty, String size);
	
	@Query(value="SELECT COUNT(*) FROM booking_details b  WHERE b.category=?1 AND b.size=?2", nativeQuery = true)
	int availableCount1(String catogoty, String size);
	
	@Query(value="SELECT COUNT(*) FROM booking_details WHERE category=?1 AND size=?2 ", nativeQuery = true)
	int availableCount2(String catogoty, String size);
	
	
	
	
	
	
	@Query(value="SELECT * FROM booking_details WHERE customer_id=?1", nativeQuery = true)
	List <Booking> getAllUsersBooking(Long userId);
	
	@Query(value="SELECT COUNT(*) FROM room_details WHERE category LIKE %?1% AND size LIKE %?2% ", nativeQuery = true)
	int availableRoomCountByCategary(String catogoty, String size);
}
