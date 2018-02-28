package org.demo.data.zone.dao;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import javax.sql.DataSource;

import org.demo.common.DemoBean;
import org.demo.data.zone.rowmapper.DemoBeanRowMapper;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;


public class DemoDAOImplTest {

	private static final Logger LOG = LoggerFactory.getLogger(DemoDAOImplTest.class);
	/*Uncomment this and change the dao setUp when running just this Test class
	 * And after you have reinvented this rule with the Open Table and Liquibase API's
	 */
/*	@ClassRule
    public static SingleInstancePostgresWithLiqubaseRule rule = SingleInstancePostgresWithLiqubaseRule.instance;*/
	
	@Mock
	NamedParameterJdbcTemplate namedJdbcTemplate;
	
	@InjectMocks
	DemoDAOImpl dao;
	
	@Before
	public void setUp(){
		LOG.info("setUp invoked");
		dao= new DemoDAOImpl();	
		//dao.setJdbcTemplate(new NamedParameterJdbcTemplate(this.rule.getDataSource()));
		System.out.println("setUp invoked");
	}
	
	@Test
	public void testGetDemoBeanById(){
		DemoBean expectedBean = new DemoBean(1,"Demo bean");
	
		//you would want to run an EmbeddedPostgresql instance and then
		//run liquibase on the project changesets
		//and test-data changeset
		
		
		//DemoBean demoBean = dao.getDemoBeanById(1);
		//assertEquals(expectedBean, demoBean);
	}
}
