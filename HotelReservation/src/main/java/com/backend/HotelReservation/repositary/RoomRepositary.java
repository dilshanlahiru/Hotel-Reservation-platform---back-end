package com.backend.HotelReservation.repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.HotelReservation.entity.Room;

@Repository
public interface RoomRepositary extends JpaRepository<Room, Long> {

}
