/**
 * 
 */
package edu.westga.concert.controller;

import edu.westga.concert.model.ConcertHall;
import edu.westga.concert.model.Terminal;

/**
 * @author danielburkhart
 * 
 *         Controller class that starts all of the threads and handles the
 *         execution of them
 * 
 */
public class ConcertHallController {

	private ConcertHall concertHall;
	private Terminal eastTerminal;
	private Terminal southTerminal;
	private Terminal northTerminal;
	private Terminal westTerminal;
	private Thread northThread;
	private Thread southThread;
	private Thread eastThread;
	private Thread westThread;

	/**
	 * Constructor of class that initializes all variables and threads.
	 */
	public ConcertHallController() {

		concertHall = new ConcertHall(10);

		northTerminal = new Terminal(concertHall);
		eastTerminal = new Terminal(concertHall);
		southTerminal = new Terminal(concertHall);
		westTerminal = new Terminal(concertHall);

		northThread = new Thread(northTerminal);
		eastThread = new Thread(eastTerminal);
		southThread = new Thread(southTerminal);
		westThread = new Thread(westTerminal);

	}

	/**
	 * Open the ticket sales which starts all the threads.
	 */
	public void openTicketSales() {
		this.startThreads();
	}

	private void startThreads() {

		northThread.start();
		eastThread.start();
		southThread.start();
		westThread.start();

	}

}
