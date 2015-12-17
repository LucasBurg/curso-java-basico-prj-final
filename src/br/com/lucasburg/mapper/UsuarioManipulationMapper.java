package br.com.lucasburg.mapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.lucasburg.dao.AbstractManipulation;
import br.com.lucasburg.database.Statement;
import br.com.lucasburg.model.Usuario;


public class UsuarioManipulationMapper extends AbstractManipulation<Usuario> {
	
	private Connection adapter;
	
	public UsuarioManipulationMapper(Connection adapter) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		this.adapter = adapter;
	}
	
	@Override
	public void insert(Usuario entity) throws SQLException {
		String sql = "insert into usuario(nome, email) values(?, ?)";
		PreparedStatement stmt = Statement.prepare(this.adapter, sql);
		stmt.setString(1, entity.getNome());
		stmt.setString(2, entity.getEmail());
		stmt.execute();
	}

	@Override
	public void update(Usuario entity) throws SQLException {
		String sql = "update usuario set nome = ?, email = ? where id = ?";
		PreparedStatement stmt = Statement.prepare(this.adapter, sql);
		stmt.setString(1, entity.getNome());
		stmt.setString(2, entity.getEmail());
		stmt.setLong(3, entity.getId());
		stmt.execute();
	}

	@Override
	public void delete(Usuario entity) throws SQLException {
		String sql = "delete from usuario where id = ?";
		PreparedStatement stmt = Statement.prepare(this.adapter, sql);
		stmt.setLong(1, entity.getId());
		stmt.execute();
	}



}
