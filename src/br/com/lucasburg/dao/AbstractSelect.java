package br.com.lucasburg.dao;

import java.util.List;

public abstract class AbstractSelect<T> {
	protected abstract List<T> fetchAll();
	protected abstract T fetchById(Long id);
}
