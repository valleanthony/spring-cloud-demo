package com.anthonyvalle.bookingservice.Exceptions;

public class BookingException extends RuntimeException {

	private String errorString;

	public BookingException(String errorMessage) {
		this.errorString = errorMessage;
	}

	public String getErrorString() {
		return errorString;
	}

	public void setErrorString(String errorString) {
		this.errorString = errorString;
	}

}
