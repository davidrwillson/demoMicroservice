package org.demo.app.zone.api;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Component
public class DemoGateway {
	
	private static final Logger LOG = Logger.getLogger(DemoGateway.class);
	
	@Autowired
	private RestTemplate restTemplate;
	
	private static final String HTTP_PROTOCOL = "http://";
	public static final String DATA_API_NAME_CONTEXT_DEMO = "/demo_data/demo";
	private static final String AUTH_HEADER = "Authorization";
	private static final String USER_HEADER = "OAM_REMOTE_USER";
	
	@Value("${data.authority}")
	private String dataAuthority;
	
	public ResponseEntity<?> getDemoBeanById(String accessToken) {
		String uri = HTTP_PROTOCOL + dataAuthority + DATA_API_NAME_CONTEXT_DEMO;
		LOG.info("Get demoBean by id");
		return this.restRequest(accessToken, uri, HttpMethod.GET, String.class);
	}
	
	 public <T> ResponseEntity<T> restRequest(String accesstoken,String url,HttpMethod httpMethod,Class<T> responseType) {	
			HttpServletRequest request = getCurrentRequest();	    
		 HttpHeaders headers = new HttpHeaders();
			headers.set(AUTH_HEADER, accesstoken);
			headers.set(USER_HEADER, request.getHeader(USER_HEADER));								
			return this.restTemplate.exchange(url, httpMethod, new HttpEntity(headers), responseType);
	 }
	 
	 private HttpServletRequest getCurrentRequest(){
			return ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
		}
	
}
