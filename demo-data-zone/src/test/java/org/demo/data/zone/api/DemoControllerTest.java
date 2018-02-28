package org.demo.data.zone.api;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;




@RunWith(MockitoJUnitRunner.class)
public class DemoControllerTest {

	@Mock
	private DemoManager demoManager;
	
	@InjectMocks
	private DemoController demoController;
	
	@Test
	public void testGetDemoBeanById(){
		when(demoManager.getDemoBeanById(1)).thenReturn(new ResponseEntity<>(null, HttpStatus.OK));
		assertEquals(demoController.getDemoBeanById(1, "token").getStatusCode(), HttpStatus.OK);
	}
}
