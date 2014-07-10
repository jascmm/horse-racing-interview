package com.intenthq.horseracing;

import java.util.ArrayList;
import java.util.Collections;

public class Track {
	
	private ArrayList<Horse> horses = new ArrayList<>();
	private ArrayList<Lane>  lanes 	= new ArrayList<>();
	
	private int trackLength;
	
	
	public Track(int trackLength) {
		this.trackLength = trackLength;
	}
	
	
	/**
	 * Process the input
	 * @param input
	 */
	public void ingestInput(String input) {

		// Split the input in the different tokens
		String parts[] = input.split("\\s+|\\t+|\\,|\\.|\\;|\\|");
		int currentToken = 0;
		currentToken = this.readNames(currentToken, parts);
		currentToken = this.readThrows(currentToken, parts);

	}
	
	/**
	 * Read the horses' names from the first line.
	 * @param start	From where should begin to process the input.
	 * @param tokens		Input tokenized
	 * @return
	 */
	private int readNames (int start, String tokens[]){
				ArrayList<Integer> holes = new ArrayList<>();
				holes.add(5);
				holes.add(10);
				holes.add(20);
				holes.add(40);
				holes.add(60);
		
		int currentTokenIndex = start;
		Horse 	horseToInsert;
		Lane 	laneToInsert;
		// Read the horses names and associate them to the corresponding lane
		int laneNumber = 1;
		while (currentTokenIndex < tokens.length && !isNumber(tokens[currentTokenIndex])) {
			if (!tokens[currentTokenIndex].equals("")) { // jump empty tokens
				
				horseToInsert 	= new Horse(tokens[currentTokenIndex]);
				laneToInsert 	= new Lane(laneNumber, horseToInsert);

				laneToInsert.setHoles(holes);
				horseToInsert.setLane(laneToInsert);

				this.horses.add(horseToInsert);
				this.lanes.add(laneToInsert);

				laneNumber++;
			}
			
			currentTokenIndex++;
		}
		return currentTokenIndex;
	}
	
	/**
	 * Read throws pairs from the input
	 * @param counter
	 * @param parts
	 * @return
	 */
	private int readThrows(int counter, String parts[]) {
		int currentToken = counter;
		int laneNumberToThrow;
		int distance;

		// Booleans values for loop control
		boolean readAllInput = (parts.length - currentToken) < 2;
		boolean raceEnds = false;
		// Read the throws from the input and execute the action
		// Ingest two token every iteration.
		while (!readAllInput && !raceEnds) {
			try {
				laneNumberToThrow = Integer.parseInt(parts[currentToken]);
				distance = Integer.parseInt(parts[currentToken + 1]);

				this.throwBall(laneNumberToThrow, distance);

				// Verify if the horse has arrive to the goal.
				raceEnds = this.lanes.get(laneNumberToThrow - 1)
						.getRunningHorse().getDistanceCovered() >= this.trackLength;
			} catch (Exception e) {
				System.out.println("Parameters doesn't have correct format");
			}
			// Check if we have at least two tokens more.
			currentToken = currentToken + 2;
			readAllInput = (parts.length - currentToken) < 2;
			
		}
		return currentToken;
	}

	/**
	 * Check if the string is a number
	 * @param string
	 * @return
	 */
	private static boolean isNumber (String string) {
		try {
			Long.parseLong(string);
		} catch (Exception e){
			return false;
		}
		return true;
		
	}
	
	/**
	 * Throw a shot against the hole with the given number and  
	 * @param laneNumber
	 * @param distance
	 */
	private void throwBall (int laneNumber, int distance) {
		try {
			Lane laneToThrow = this.lanes.get(laneNumber-1);
			laneToThrow.throwBall(distance);
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Lane number has not a horse");
		}
	}
	
	
	/**
	 * Collect the result and set in the correct format.
	 * @return
	 */
	public String getRaceResults() {
		String output = "Position, Lane, Horse name\n";
		Collections.sort(horses, new HorseComparator());

		int position = 1;
		for (Horse horse : horses) {
			output = output + position + ", " + horse.getLane().getLaneNumber()
					+ ", " + horse.getName();
			
			if (position < horses.size()) {
				output = output + "\n";
			}
			position++;
		}

		return output;

	}
	
}
