package com.intenthq.horseracing;

public class Horse {
	private String name = "";
	private Lane lane;
	private int distanceCovered = 0;
	
	public Horse(String name) {
		this.name = name;
	}

	public int getDistanceCovered() {
		return distanceCovered;
	}

	public String getName() {
		return name;
	}
	
	public Lane getLane() {
		return lane;
	}
	
	public void setLane(Lane lane) {
		this.lane = lane;
	}
	
	
	public void move (int distance) {
		this.distanceCovered = this.distanceCovered + distance;
	}

}
