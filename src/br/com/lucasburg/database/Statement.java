package br.com.lucasburg.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Statement {
	public static PreparedStatement prepare(Connection adapter, String sql) throws SQLException {
		return adapter.prepareStatement(sql);
	}
}
