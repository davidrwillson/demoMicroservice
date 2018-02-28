package org.demo.app.zone.api;

import org.demo.common.DemoBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "demo-controller")
@RestController
@RequestMapping("/demo")
public class DemoController {
	
	private static final Logger LOG = LoggerFactory.getLogger(DemoController.class);


	@Autowired
	private DemoGateway gateway;
	
	//version check?
	@ApiOperation(value = "", notes = "Get the demo bean")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 401, message = "User is not authorized to get demo bean"),
			@ApiResponse(code = 500, message = "Apologies, but /demo GET is not available at the moment") })	
	@RequestMapping(method = RequestMethod.GET, value ="", produces = "application/json")
	@CrossOrigin(origins = "")
	public ResponseEntity<?> getDemoBeanById(
			@RequestParam("id") Integer id,
			@RequestHeader(value = "Authorization") String accesstoken) {
		return gateway.getDemoBeanById(accesstoken, id);
	}

}
