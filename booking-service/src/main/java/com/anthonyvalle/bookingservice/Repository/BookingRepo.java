package com.anthonyvalle.bookingservice.Repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anthonyvalle.bookingservice.Models.Booking;

@Repository
public interface BookingRepo extends JpaRepository<Booking, Long> {

	Set<Booking> findByuserId(long id);

}
