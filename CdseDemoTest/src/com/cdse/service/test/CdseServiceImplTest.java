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

import com.cdse.controller.PersonController;
import com.cdse.dao.CdseDao;
import com.cdse.domain.CdseEntity;
import com.cdse.domain.Person;
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
	CdseDao<Person> entityDaoMock;
	
	@Mock
	Person personMock;
	
	@Test
	public void testInsert() throws IOException {
		
		doNothing().when(entityDaoMock).insert(personMock);
		doNothing().when(personMock).setState(EntityState.NEW);
		doNothing().when(personMock).populate();
		
		
		CdseServiceImpl<Person> sut = new CdseServiceImpl<Person>();
		sut.setEntityDao(entityDaoMock);
		sut.insert(personMock);
		
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
