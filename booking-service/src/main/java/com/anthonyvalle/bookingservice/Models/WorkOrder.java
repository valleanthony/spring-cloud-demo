package com.anthonyvalle.bookingservice.Models;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

public class WorkOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	// private User user;
	private boolean approvedStatus;
	@OneToOne
	private WorkOrder workOrder;

}
