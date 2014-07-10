package com.intenthq.horseracing;

import java.util.Comparator;

public class HorseComparator implements Comparator<Horse> {

	/**
	 * Compare to horses by the distance
	 */
	@Override
	public int compare(Horse arg0, Horse arg1) {
		if (arg0.getDistanceCovered() < arg1.getDistanceCovered()) {
			return 1;
		} else if (arg0.getDistanceCovered() > arg1.getDistanceCovered()) {
			return -1;
		} else {
			return 0;
		}
	}

}
