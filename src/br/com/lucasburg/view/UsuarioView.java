package br.com.lucasburg.view;

import javax.swing.JFrame;

import br.com.lucasburg.form.UsuarioForm;

public class UsuarioView extends JFrame {

	private static final long serialVersionUID = 7747613308734722114L;

	public UsuarioView(UsuarioForm form) {
		super();
		super.setSize(300, 500);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		super.add(form);
		super.setVisible(true);
	}

}
