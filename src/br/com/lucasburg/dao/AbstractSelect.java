package br.com.lucasburg.dao;

import java.sql.SQLException;
import java.util.List;

public abstract class AbstractSelect<T> {
	protected abstract List<T> fetchAll() throws SQLException, Exception;
	protected abstract T fetchById(Long id);
}
