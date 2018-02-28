package org.demo.data.zone.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class DemoController {
	
	@Autowired
	DemoManager demoManager;
	
	//@VersionCheck annotation?
	//@Authorization annotation?
	@RequestMapping(method = RequestMethod.GET, produces = "application/json", value="/")
	@CrossOrigin(origins = "")
	public ResponseEntity<?> getDemoBeanById(@RequestParam("id") Integer id,
			@RequestHeader(value = "Authorization") String accessToken) {
		return demoManager.getDemoBeanById(id);
	}

}
