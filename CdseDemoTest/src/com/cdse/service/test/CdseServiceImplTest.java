package com.cdse.service.test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.io.IOException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.cdse.controller.ContactController;
import com.cdse.dao.CdseDao;
import com.cdse.domain.CdseEntity;
import com.cdse.domain.Contact;
import com.cdse.domain.EntityState;
import com.cdse.service.CdseServiceImpl;

//@RunWith(MockitoJUnitRunner.class)
public class CdseServiceImplTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Mock
	CdseDao<Contact> entityDaoMock;
	
	@Mock
	Contact contactMock;
	
	@Test
	public void testInsert() throws IOException {
		
		doNothing().when(entityDaoMock).insert(contactMock);
		doNothing().when(contactMock).setState(EntityState.NEW);
		doNothing().when(contactMock).populate();
		
		
		CdseServiceImpl<Contact> sut = new CdseServiceImpl<Contact>();
		sut.setEntityDao(entityDaoMock);
		sut.insert(contactMock);
		
		assertTrue(1==1);
	}

	@Test
	public void testInsertOrUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	public void testGet() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetList() {
		fail("Not yet implemented");
	}

}
