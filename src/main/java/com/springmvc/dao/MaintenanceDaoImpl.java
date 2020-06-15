package com.springmvc.dao;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.springmvc.model.Maintenance;

public class MaintenanceDaoImpl implements MaintenanceDao {

	@Autowired
	DataSource datasource;

	@Autowired
	JdbcTemplate jdbcTemplate;

	public Maintenance getTableDetails(Maintenance tableDetails) {

		String sql = "select * from "+ tableDetails.getTableName();

		List<Maintenance> tableInfo = jdbcTemplate.query(sql, new MaintenanceMapper());
		
		Maintenance abc = tableInfo.get(0);
		abc.setTableName(tableDetails.getTableName());
		
		return tableInfo.size() > 0 ? tableInfo.get(0) : null;
	}
}

	class MaintenanceMapper implements RowMapper<Maintenance> {

		public Maintenance mapRow(ResultSet rs, int arg1) throws SQLException {
			Maintenance table = new Maintenance();

			//table.setTableName(rs.getString("tableName"));
			ResultSetMetaData rsmd = rs.getMetaData();
			
			ArrayList<String> columnNames = new ArrayList<String>();
			
			int columnCount = rsmd.getColumnCount();
			
			for(int i=1;i<=columnCount;i++) {
				columnNames.add(rsmd.getColumnName(i));
			}
			table.setColumnNames(columnNames);

			return table;
		}
	}
