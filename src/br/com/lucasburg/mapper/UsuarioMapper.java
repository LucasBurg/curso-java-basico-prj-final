package br.com.lucasburg.mapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.lucasburg.dao.AbstractManipulation;
import br.com.lucasburg.database.Statement;
import br.com.lucasburg.model.Usuario;


public class UsuarioMapper extends AbstractManipulation<Usuario> {
	
	private Connection adapter;
	
	public UsuarioMapper(Connection adapter) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		this.adapter = adapter;//Adapter.criar();
	}
	
	@Override
	protected void insert(Usuario entity) throws SQLException {
		String sql = "insert into usuario(nome, email) values(?, ?)";
		PreparedStatement stmt = Statement.prepare(this.adapter, sql);
		stmt.setString(1, entity.getNome());
		stmt.setString(2, entity.getEmail());
		stmt.execute();
	}

	@Override
	protected void update(Usuario entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void delete(Usuario entity) {
		// TODO Auto-generated method stub
		
	}



}
