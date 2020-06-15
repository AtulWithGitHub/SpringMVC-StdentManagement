package com.springmvc.model;

import java.util.ArrayList;

public class Maintenance {

	private String tableName;
	private ArrayList<String> columnNames;

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public ArrayList<String> getColumnNames() {
		return columnNames;
	}

	public void setColumnNames(ArrayList<String> columnNames) {
		this.columnNames = columnNames;
	}

}
