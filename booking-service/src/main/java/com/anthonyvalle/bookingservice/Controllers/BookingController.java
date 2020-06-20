package com.anthonyvalle.bookingservice.Controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import com.anthonyvalle.bookingservice.Exceptions.BookingException;
import com.anthonyvalle.bookingservice.Models.Booking;
import com.anthonyvalle.bookingservice.Services.BookingServices;

@RestController
@RequestMapping("/api/v1/")
public class BookingController {

	private static final Logger log = LoggerFactory.getLogger(BookingController.class);

	@Autowired
	BookingServices bookingService;

	@GetMapping
	public ResponseEntity<List<Booking>> getAllBookings() {
		return new ResponseEntity<List<Booking>>(bookingService.getAll(), HttpStatus.ACCEPTED);

	}

	@GetMapping("{id}")
	public ResponseEntity<Booking> getBookingByBookingID(@PathVariable long id) throws BookingException {

		Booking holder = null;
		try {
			holder = bookingService.findBookingByBookingID(id);

		} catch (Exception e) {
			log.error(e.getMessage());
			throw new HttpClientErrorException(HttpStatus.NOT_FOUND, "Booking not found");
		}

		return new ResponseEntity<Booking>(holder, HttpStatus.ACCEPTED);
	}

	@PostMapping
	public ResponseEntity<Booking> postNewBooking(@RequestBody Booking booking) throws BookingException {
		Booking responseBooking = null;

		if (booking == null) {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Booking cannot be null");
		}

		try {
			responseBooking = bookingService.addBooking(booking);
		} catch (Exception e) {
			log.error(String.format("Booking could not be saved %s" + e.getMessage()));
		}
		return new ResponseEntity<Booking>(responseBooking, HttpStatus.ACCEPTED);
	}

	@PutMapping("{id}")
	public ResponseEntity<Booking> updateBooking(@PathVariable long id, @RequestBody Booking booking)
			throws BookingException {
		if (booking == null) {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Booking object is empty");
		}
		Booking holderBooking = null;

		try {
			holderBooking = bookingService.updateBooking(id, booking);

		} catch (Exception e) {
			log.error(String.format("Booking could not be updated %s" + e.getMessage()));
		}
		return new ResponseEntity<Booking>(holderBooking, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteBoooking(@PathVariable long id) {
		String holderString = "";
		try {
			holderString = bookingService.deleteByBookingId(id);

		} catch (Exception e) {
			log.error(String.format(" *** Booking: %s" + e.getMessage()));// TODO: handle exception
		}
		return new ResponseEntity<String>(holderString, HttpStatus.ACCEPTED);

	}

}
