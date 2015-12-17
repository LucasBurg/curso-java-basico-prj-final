package br.com.lucasburg.view;

import java.util.List;

import javax.swing.JTable;

import br.com.lucasburg.model.Usuario;
import br.com.lucasburg.model.UsuarioTable;

public class UsuarioTableView extends JTable {

	private static final long serialVersionUID = 5011650039681592199L;
	
	private UsuarioTable tableModel = new UsuarioTable();
	
	public UsuarioTableView() {
		super();
		this.tableModel = new UsuarioTable();
		super.setModel(this.tableModel);
	}
	
	public void load(List<Usuario> usuarios) {
		this.tableModel.load(usuarios);
	}
	
	public Usuario getUsuarioSelecionado() {
		int index = super.getSelectedRow();
		return this.tableModel.getUsuarioAt(index);
	}

}
