package br.com.lucasburg.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Select {
	public static ResultSet execute(Connection adapter, String sql) throws SQLException {
		Statement stmt = adapter.createStatement();
		return stmt.executeQuery(sql);
	}
}
