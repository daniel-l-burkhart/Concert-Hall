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
	
	private ArrayList<Integer> seats;

	/**
	 * 
	 */
	public ConcertHall(int seats) {
		
		this.seats = new ArrayList<Integer>(seats);
	}

	public boolean claimSeat(int seat) {
		
		this.seats.get(seat);
		
		try {
			Thread.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		//this.seats.add(seat, 1);
		
		return true;
		
	}
	
	public ArrayList<Integer> getOpenSeats() {
		return new ArrayList<Integer>();
	}

}
