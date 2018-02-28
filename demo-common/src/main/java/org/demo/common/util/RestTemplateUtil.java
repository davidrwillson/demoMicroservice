package org.demo.common.util;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Component
public class RestTemplateUtil {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private LoadBalancerClient loadBalancer;

	@Autowired
	private Tracer tracer;

	private static final String AUTH_HEADER = "Authorization";
	private static final String USER_HEADER = "OAM_REMOTE_USER";

	public RestTemplateUtil() {
		// Default Constructor
	}

	public <T> ResponseEntity<T> restRequest(String accesstoken, String url, HttpMethod httpMethod,
			Class<T> responseType) {
		HttpServletRequest request = getCurrentRequest();
		HttpHeaders headers = new HttpHeaders();
		headers.set(AUTH_HEADER, accesstoken);
		headers.set(USER_HEADER, request.getHeader(USER_HEADER));
		return this.restTemplate.exchange(url, httpMethod, new HttpEntity(headers), responseType);
	}

	private HttpServletRequest getCurrentRequest() {
		return ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
	}

}
