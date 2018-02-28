package org.demo.app.zone.api;


import static org.mockito.Mockito.verify;

import org.demo.common.util.RestTemplateUtil;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.core.JsonProcessingException;

public class DemoGatewayTest {
	
	@InjectMocks
	private DemoGateway demoGateway;
	
	@Mock
	private RestTemplateUtil restTemplateUtil;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testGetDemoBeanById() throws JsonProcessingException {
		//given that the circuit is open
		String url = "http://null/demo_data/demo?id=1" ;
		
		//when
		ResponseEntity<?> response = demoGateway.getDemoBeanById("token", 1);
		
		//then
		verify(restTemplateUtil).restRequest("token", url, HttpMethod.GET, String.class);
	}

}
