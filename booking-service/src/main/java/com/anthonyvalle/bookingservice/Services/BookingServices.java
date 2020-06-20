package com.anthonyvalle.bookingservice.Services;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anthonyvalle.bookingservice.Exceptions.BookingException;
import com.anthonyvalle.bookingservice.Models.Booking;
import com.anthonyvalle.bookingservice.Repository.BookingRepo;

@Service
public class BookingServices {

	private static final Logger log = LoggerFactory.getLogger(BookingServices.class);

	@Autowired
	BookingRepo bookingRepo;

	public Booking findBookingByBookingID(long bookingID) {
		if (!bookingRepo.existsById(bookingID)) {
			throw new BookingException("Booking not found");
		}

		return bookingRepo.findById(bookingID).get();
	}

	public Collection<Booking> findBookingByUserID(long userID) {

		// implement this
//		if (!bookingRepo.findbyuserId(userID)){
//		throw new BookingException("User not found");
//	}

		Set<Booking> set = new HashSet<>();
		set = bookingRepo.findByuserId(userID);
		return set;
	}

	public Booking addBooking(Booking booking) {
		if (booking == null) {
			throw new BookingException("Booking object is null");
		}
		return bookingRepo.saveAndFlush(booking);
	}

	public Booking updateBooking(long id, Booking booking) {
		log.warn(
				"A booking is about to be updated  ***" + "Booking id:" + Long.toString(id) + " " + booking.toString());
		if (!bookingRepo.findById(id).isPresent()) {
			throw new BookingException("Booking could not be found");
		}
		Booking dbBooking = bookingRepo.findById(id).get();
		log.warn("Original booking *** " + dbBooking.toString());
		BeanUtils.copyProperties(booking, dbBooking, "id");
		log.warn("Updated booking *** " + dbBooking.toString());
		bookingRepo.saveAndFlush(dbBooking);
		log.warn(" Booking Saved *** " + dbBooking.toString());
		return dbBooking;

	}

	public List<Booking> getAll() {
		return bookingRepo.findAll();

	}

	public String deleteByBookingId(long id) {
		String response = "Booking Deleted";
		Booking hold = null;
		if (!bookingRepo.existsById(id)) {
			throw new BookingException("Booking not found");
		}
		hold = bookingRepo.findById(id).get();
		log.warn("Booking is about to be Deleted *** " + hold.toString());
		bookingRepo.deleteById(id);
		log.warn("Booking Deleted");
		hold = null;
		return response;

	}

}
