package br.com.lucasburg.mapper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.lucasburg.dao.AbstractSelect;
import br.com.lucasburg.database.Select;
import br.com.lucasburg.model.Usuario;

public class UsuarioSelectMapper extends AbstractSelect<Usuario> {

	private Connection adapter;	
	
	public UsuarioSelectMapper(Connection adapter) {
		this.adapter = adapter;
	}
	
	@Override
	public List<Usuario> fetchAll() throws SQLException, Exception {
		
		
		String sql = "select * from usuario";
		ResultSet usuarios = Select.execute(this.adapter, sql);
		List<Usuario> lista = new ArrayList<Usuario>();
		
		while(usuarios.next()) {
			
			Usuario model = new Usuario();
			model.setId(usuarios.getLong("id"));
			model.setNome(usuarios.getString("nome"));
			model.setEmail(usuarios.getString("email"));
			
			lista.add(model);
			
		}
		
		
		return lista;
	}

	@Override
	public Usuario fetchById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
