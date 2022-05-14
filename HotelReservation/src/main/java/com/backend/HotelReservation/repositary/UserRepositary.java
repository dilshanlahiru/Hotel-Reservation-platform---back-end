package com.backend.HotelReservation.repositary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.HotelReservation.entity.User;


@Repository
public interface UserRepositary extends JpaRepository<User, Long>{

}
