package org.demo.data.zone.api;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;


import org.demo.common.DemoBean;
import org.demo.data.zone.dao.DemoDAOImpl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


@RunWith(MockitoJUnitRunner.class)
public class DemoManagerTest {

	@Mock
	DemoDAOImpl demoDAOImpl;
	
	@InjectMocks
	DemoManager demoManager;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testGetDemoBeanById(){
		//given
		DemoBean demoBean = new DemoBean(1,"Demo bean");
		//when
		when(demoDAOImpl.getDemoBeanById(1)).thenReturn(demoBean);
		//then
		ResponseEntity<?> response = demoManager.getDemoBeanById(1);
		assertEquals( HttpStatus.OK, response.getStatusCode());
	}
	
	@Test
	public void testGetDemoBeanByIdNullId(){
		//given
				
				//when
				when(demoDAOImpl.getDemoBeanById(null)).thenReturn(null);
				//then
				ResponseEntity<?> response = demoManager.getDemoBeanById(null);
				assertEquals( HttpStatus.UNPROCESSABLE_ENTITY, response.getStatusCode());
	}
	
}
