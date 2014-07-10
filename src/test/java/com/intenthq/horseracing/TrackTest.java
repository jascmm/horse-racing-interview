package com.intenthq.horseracing;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TrackTest {
	private Track t1;
	private static final String SAMPLE_INPUT = "Star, Dakota, Cheyenne, Misty, Spirit\n"+
            "1 60\n"+
            "3 5\n"+
            "1 60\n"+
            "4 5\n"+
            "4 10\n"+
            "2 5\n"+
            "5 10\n"+
            "1 60\n"+
            "3 20\n"+
            "7 10\n"+
            "1 40\n"+
            "2 60";
	private static final String SAMPLE_OUTPUT = "Position, Lane, Horse name\n"+
			    "1, 1, Star\n"+
			    "2, 3, Cheyenne\n"+
			    "3, 4, Misty\n"+
			    "4, 5, Spirit\n"+
			    "5, 2, Dakota";

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		t1 = new Track(220);
		
		t1.ingestInput(SAMPLE_INPUT);
		
		assertEquals(SAMPLE_OUTPUT, t1.getRaceResults());
	}

}
