package com.intenthq.horseracing;

import static org.junit.Assert.*;

import static org.mockito.Mockito.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class horseTest {
	Horse h1, h2;
	String name1 ="Star", name2 ="Dakota";
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		
	}

	@Before
	public void setUp() throws Exception {
		h1 = new Horse("Star");
		h2 = new Horse("Dakota");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testConstructor() {
		assertEquals(name1, h1.getName());
		
		assertEquals(name2, h2.getName());
		
		assertEquals(0, h1.getDistanceCovered());
		
		assertEquals(0, h2.getDistanceCovered());
	}
	
	@Test
	public void testMove(){
		h1.move(20);
		h2.move(30);
		
		assertEquals(20, h1.getDistanceCovered());
		
		assertEquals(30, h2.getDistanceCovered());
		
	}
	
	@Test
	public void testSetAndGetLane(){
		Lane l1, l2;
		l1 = mock(Lane.class);
		l2 = mock(Lane.class);
		h1.setLane(l1);
		h2.setLane(l2);
		assertEquals(l1, h1.getLane());
		assertEquals(l2, h2.getLane());
		
	}

}
