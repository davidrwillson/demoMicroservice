package org.demo.data.zone.api;

import org.demo.common.DemoBean;
import org.demo.data.zone.dao.DemoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class DemoManager {
	@Autowired
	DemoDAO demoDAO;
	
	public ResponseEntity<?> getDemoBeanById(Integer id) {
		if(id != null && id > 0){
			DemoBean bean = demoDAO.getDemoBeanById(id);
			if(bean != null){
				return new ResponseEntity<>(bean, HttpStatus.OK);
			}else{
				return new ResponseEntity<>(null, HttpStatus.OK);
			}
		} else {
			return new ResponseEntity<>(null, HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}
}
