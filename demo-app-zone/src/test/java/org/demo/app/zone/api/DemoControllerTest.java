package org.demo.app.zone.api;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.netflix.hystrix.Hystrix;


@RunWith(MockitoJUnitRunner.class)
public class DemoControllerTest {
	
	@InjectMocks
	private DemoController demoController;
	
	@Mock
	private DemoGateway demoGateway;
	
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);

		MockHttpServletRequest request = new MockHttpServletRequest();
        MockHttpSession session = new MockHttpSession();
        request.setSession(session);
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        Hystrix.reset();
	}
	
	@After
	public void tearDown() throws Exception {
		demoGateway = null;
		demoController = null;
	}
	
	@Test
	public void testGetDemoBeanById() throws JsonProcessingException {
		//given
		when(demoGateway.getDemoBeanById("token", 1)).thenReturn(new ResponseEntity<>(null, HttpStatus.OK));
		//when
		ResponseEntity<?> response = demoController.getDemoBeanById(1, "token");				
		
		//then
		assertEquals(response.getStatusCode(), HttpStatus.OK);
	}

}
