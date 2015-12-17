package br.com.lucasburg.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class UsuarioTable extends AbstractTableModel {

	private static final long serialVersionUID = 2090510940226096281L;

	private List<Usuario> usuarios = new ArrayList<Usuario>();
	
	private String[] columnNames = {"Id", "Nome", "E-mail"};
	
	//private Class<?>[] columnTypes = {Long.class, String.class, String.class};
	

	public void load(List<Usuario> usuarios) {
		this.usuarios = usuarios;
		super.fireTableDataChanged();
	}
	
	public Usuario getUsuarioAt(int index) {
		return this.usuarios.get(index);
	}
	
	@Override
	public int getColumnCount() {
		return this.columnNames.length;
	}

	@Override
	public int getRowCount() {
		return this.usuarios.size();
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		
		Usuario usuario = this.usuarios.get(arg0);
		
		switch(arg1) {
		case 0:
			return usuario.getId();
		case 1:
			return usuario.getNome();
		case 2:
			return usuario.getEmail();
		}
		
		return null;
	}

}
