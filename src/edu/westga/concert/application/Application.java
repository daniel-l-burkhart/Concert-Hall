package edu.westga.concert.application;

import edu.westga.concert.controller.ConcertHallController;

public class Application {

	public static void main(String[] args) {

		ConcertHallController controller = new ConcertHallController();

		controller.openTicketSales();

	}

}
