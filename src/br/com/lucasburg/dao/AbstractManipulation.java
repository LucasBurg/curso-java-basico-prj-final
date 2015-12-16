package br.com.lucasburg.dao;

public abstract class AbstractManipulation<T> {
	abstract void insert(T entity);
	abstract void update(T entity);
	abstract void delete(T entity);
}
