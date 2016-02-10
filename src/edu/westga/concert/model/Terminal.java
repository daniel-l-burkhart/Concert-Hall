/**
 * 
 */
package edu.westga.concert.model;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author danielburkhart
 *
 */
public class Terminal implements Runnable {

	private ConcertHall concertHall;
	private boolean keepWorking;
	private Random randomizer;

	/**
	 * 
	 */
	public Terminal(ConcertHall concertHall) {
		this.concertHall = concertHall;
		this.keepWorking = true;
		this.randomizer = new Random();
	}

	@Override
	public void run() {

		while (this.keepWorking) {

			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			ArrayList<Integer> openSeats = this.concertHall.getOpenSeats();

			if (this.concertHall.claimSeat(this.randomizer.nextInt(openSeats.size()))) {
				System.out.println("Seat claimed successfully!");
			} else {
				System.out.println("Seat already taken!");
			}

		}

	}

	public void stop() {
		this.keepWorking = false;
	}

}
