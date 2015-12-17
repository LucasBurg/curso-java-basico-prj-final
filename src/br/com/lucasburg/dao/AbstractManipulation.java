package br.com.lucasburg.dao;

import java.sql.SQLException;

public abstract class AbstractManipulation<T> {
	protected abstract void insert(T entity) throws SQLException;
	protected abstract void update(T entity) throws SQLException;
	protected abstract void delete(T entity) throws SQLException;
}
