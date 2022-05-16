package com.backend.HotelReservation.repositary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.backend.HotelReservation.entity.User;


@Repository
public interface UserRepositary extends JpaRepository<User, Long>{
	
	@Query(value="SELECT user_id FROM user_details u  WHERE u.email = ?1", nativeQuery = true)
	Long GetUserByid(String email);

}
