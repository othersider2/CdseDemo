package com.cdse.controller.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.cdse.controller.ContactController;

public class ContactControllerTest {
	
	ContactController sut;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.sut = new ContactController();
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSubmitContactForm() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetContactForm() {
		fail("Not yet implemented");
	}

}
