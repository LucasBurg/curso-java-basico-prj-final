package br.com.lucasburg.dao;

import java.util.List;

public abstract class AbstractSelectDao<T> {
	abstract List<T> fetchAll();
	abstract T fetchById(Long id);
}
