package com.intenthq.horseracing;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;


public class LaneTest {
	private Lane l1, l2;
	
	private Horse h1;
	
	private Horse h2;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		h1 = mock(Horse.class);
		h2 = mock(Horse.class);
		
		l1 = new Lane(1, h1);
		l2 = new Lane(2, h2);
		
		ArrayList<Integer> holes = new ArrayList<>();
		holes.add(20);
		holes.add(30);
		l1.setHoles(holes);
		l2.setHoles(holes);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testThrowBall() {
		l1.throwBall(20);
		l2.throwBall(30);
		
		verify(h1).move(20);
		verify(h2).move(30);
		

		l2.throwBall(40);
		verifyNoMoreInteractions(h2);
	}
	
	@Test
	public void testGetNumber(){
		assertEquals(1, l1.getLaneNumber());
		assertEquals(2, l2.getLaneNumber());
	}

}
