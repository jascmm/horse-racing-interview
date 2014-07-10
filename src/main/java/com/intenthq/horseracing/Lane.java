package com.intenthq.horseracing;

import java.util.Collection;

public class Lane {
	
	private Horse runningHorse;

	private int laneNumber;

	private Collection<Integer> holes;
	
	/**
	 * 
	 * @param laneNumber	The number of this lane.
	 * @param horse			Reference to the horse running in this lane
	 */
	public Lane (int laneNumber, Horse horse) {
		this.runningHorse = horse;
		this.setLaneNumber(laneNumber);
	}

	/**
	 * Throw a ball again a hole in this line. If the quantity
	 * doesn't match with the type of holes set previously, the
	 * action won't be perform.
	 * @param quantity
	 */
	public void throwBall(int quantity) {

		if (holes.contains(quantity)) {
			this.runningHorse.move(quantity);
		}

	}

	/*
	 * Getters and Setters
	 */
	
	public int getLaneNumber() {
		return laneNumber;
	}

	public void setLaneNumber(int laneNumber) {
		this.laneNumber = laneNumber;
	}

	public Collection<Integer> getHoles() {
		return holes;
	}

	public void setHoles(Collection<Integer> holes) {
		this.holes = holes;
	}

	public Horse getRunningHorse() {
		return runningHorse;
	}

	public void setRunningHorse(Horse runningHorse) {
		this.runningHorse = runningHorse;
	}
}
