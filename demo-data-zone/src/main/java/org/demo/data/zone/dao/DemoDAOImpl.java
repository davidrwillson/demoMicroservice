package org.demo.data.zone.dao;

import org.demo.common.DemoBean;
import org.demo.data.zone.rowmapper.DemoBeanRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;


public class DemoDAOImpl implements DemoDAO {
	private static final String ID_PARAM = "ID";
	static final String DEMO_BEAN_SQL = "SELECT ID, NAME FROM DEMO.DEMO_BEAN WHERE ID = :ID";
	@Autowired
	private NamedParameterJdbcTemplate namedJdbcTemplate;

	@Override
	public DemoBean getDemoBeanById(Integer id) {
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		parameters.addValue(ID_PARAM, id);
		return namedJdbcTemplate.queryForObject(DEMO_BEAN_SQL,parameters, new DemoBeanRowMapper());		
	}
	
	//public void setJdbcTemplate(NamedParameterJdbcTemplate jdbcTemplate) {
//		this.namedJdbcTemplate = jdbcTemplate;
	//}

}
