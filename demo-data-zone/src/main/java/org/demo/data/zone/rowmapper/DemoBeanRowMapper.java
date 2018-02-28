package org.demo.data.zone.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.demo.common.DemoBean;
import org.springframework.jdbc.core.RowMapper;

public class DemoBeanRowMapper implements RowMapper<DemoBean> {

	@Override
	public DemoBean mapRow(ResultSet rs, int arg1) throws SQLException {
		DemoBean demoBean = new DemoBean();
		demoBean.setId(rs.getInt("ID"));
		demoBean.setName(rs.getString("NAME"));
		return demoBean;
	}

}
