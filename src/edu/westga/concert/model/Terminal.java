/**
 * 
 */
package edu.westga.concert.model;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author daniel burkhart
 * 
 *         Ticket Terminal class for ConcertHall. Looks through open seats and
 *         tries to claim them for customers.
 *
 */
public class Terminal implements Runnable {

	private ConcertHall concertHall;
	private boolean keepWorking;
	private int randomValue;
	private Random random;
	private ArrayList<Integer> openSeats;

	/**
	 * Constructor of class that requires a concertHall Object.
	 * 
	 * @Precondition concertHall must not be null
	 * @Postcondition a terminal object is created
	 */
	public Terminal(ConcertHall concertHall) {

		if (concertHall == null) {
			throw new IllegalArgumentException("conert hall cannot be null");
		}

		this.concertHall = concertHall;
		this.keepWorking = true;
		this.randomValue = 0;
		this.openSeats = new ArrayList<Integer>();
		this.random = new Random();

	}

	/**
	 * Run method that checks the open seats, gets a random seat and tries to
	 * claim it.
	 */
	@Override
	public void run() {

		while (this.keepWorking) {

			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			this.openSeats = this.concertHall.getOpenSeats();
			int size = this.openSeats.size();

			if (size == 0) {

				this.stop();

			} else if (size != 0) {

				this.randomValue = this.random.nextInt(size);

				this.attemptToClaimSeat();

			}
		}

	}

	private void attemptToClaimSeat() {

		if (this.concertHall.claimSeat(this.openSeats.get(this.randomValue))) {

			System.out.println("Seat " + this.openSeats.get(this.randomValue) + " claimed successfully!\n");

		} else {
			System.out.println("Seat " + this.openSeats.get(this.randomValue) + " already taken!\n");
		}
	}

	public void stop() {
		this.keepWorking = false;
	}

}
