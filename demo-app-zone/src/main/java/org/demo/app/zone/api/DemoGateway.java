package org.demo.app.zone.api;


import org.apache.log4j.Logger;
import org.demo.common.util.RestTemplateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class DemoGateway {
	
	private static final Logger LOG = Logger.getLogger(DemoGateway.class);
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private RestTemplateUtil restTemplateUtil;
	
	private static final String HTTP_PROTOCOL = "http://";
	public static final String DATA_API_NAME_CONTEXT_DEMO = "/demo_data/demo";
	private static final String AUTH_HEADER = "Authorization";
	private static final String USER_HEADER = "OAM_REMOTE_USER";
	
	@Value("${data.authority}")
	private String dataAuthority;
	
	public ResponseEntity<?> getDemoBeanById(String accessToken, Integer id) {
		String uri = HTTP_PROTOCOL + dataAuthority + DATA_API_NAME_CONTEXT_DEMO+"?id="+id;
		LOG.info("Get demoBean by id");
		return restTemplateUtil.restRequest(accessToken, uri, HttpMethod.GET, String.class);
	}
	
	
	
}
