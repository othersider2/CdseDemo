package com.cdse.controller.test;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.cdse.controller.PersonController;

public class PersonControllerTest {
	
	PersonController sut;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.sut = new PersonController();
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSubmitPersonForm() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetPersonForm() {
		fail("Not yet implemented");
	}

}
