package br.com.lucasburg.dao;

import java.util.List;

public abstract class AbstractSelect<T> {
	abstract List<T> fetchAll();
	abstract T fetchById(Long id);
}
