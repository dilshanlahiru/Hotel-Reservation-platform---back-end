package com.backend.HotelReservation.repositary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.HotelReservation.entity.PaymentDetails;


@Repository
public interface PaymentDetailsRepositary extends JpaRepository<PaymentDetails, Long>{

}
