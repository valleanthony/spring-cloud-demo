package com.anthonyvalle.bookingservice.Repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anthonyvalle.bookingservice.Models.Booking;

public interface BookingRepo extends JpaRepository<Booking, Long> {

	ArrayList<Booking> findByuserId(long id);

}
