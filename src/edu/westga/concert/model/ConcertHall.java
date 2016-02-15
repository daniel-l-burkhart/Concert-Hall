/**
 * 
 */
package edu.westga.concert.model;

import java.util.ArrayList;

/**
 * @author danielburkhart
 *
 */
public class ConcertHall {

	private ArrayList<Integer> openSeats;

	/**
	 * Concert hall constructor
	 * 
	 * @param seats
	 *            The number of seats at the beginning of the ticket sales.
	 * @Precondition None
	 * @Postcondition a concert hall object is created.
	 */
	public ConcertHall(int seats) {

		this.openSeats = new ArrayList<Integer>();

		for (int i = 0; i < seats; i++) {
			this.openSeats.add(i);
		}
	}

	/**
	 * Method that allows a terminal to claim a seat in the concert hall
	 * 
	 * @param seat
	 *            The current seat in question
	 * @return True if the seat was available and can be claimed, false
	 *         otherwise.
	 */
	synchronized public boolean claimSeat(int seat) {

		int seatStatus = this.openSeats.get(seat);

		System.out.println("Customer selected seat " + seat);

		try {
			Thread.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		if (seatStatus != -1) {
			this.openSeats.set(seat, -1);
			return true;
		} else {
			return false;
		}

	}

	/**
	 * Gets the open seats left in the concert Hall
	 * 
	 * @return An arrayList of all the open seats.
	 */
	public ArrayList<Integer> getOpenSeats() {

		ArrayList<Integer> safeOpenSeats = new ArrayList<Integer>();

		for (Integer seat : this.openSeats) {

			if (seat != -1) {
				safeOpenSeats.add(seat);
			}

		}

		return safeOpenSeats;
	}

}
