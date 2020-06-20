package com.anthonyvalle.bookingservice.Models;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private long userId;
	private LocalDate bookingDate;
	private LocalDateTime scheduleDateTime;
	private BigDecimal bookingPriceQuoted;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public LocalDate getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}

	public LocalDateTime getScheduleDateTime() {
		return scheduleDateTime;
	}

	public void setScheduleDateTime(LocalDateTime scheduleDateTime) {
		this.scheduleDateTime = scheduleDateTime;
	}

	public BigDecimal getBookingPriceQuoted() {
		return bookingPriceQuoted;
	}

	public void setBookingPriceQuoted(BigDecimal bookingPriceQuoted) {
		this.bookingPriceQuoted = bookingPriceQuoted;
	}

	public Booking() {

	}

	public Booking(long id, long userId, LocalDate bookingDate, LocalDateTime scheduleDateTime,
			BigDecimal bookingPriceQuoted) {
		super();
		this.id = id;
		this.userId = userId;
		this.bookingDate = bookingDate;
		this.scheduleDateTime = scheduleDateTime;
		this.bookingPriceQuoted = bookingPriceQuoted;
	}

	@Override
	public String toString() {
		return "Booking [id=" + id + ", userId=" + userId + ", bookingDate=" + bookingDate + ", scheduleDateTime="
				+ scheduleDateTime + ", bookingPriceQuoted=" + bookingPriceQuoted + "]";
	}

}
