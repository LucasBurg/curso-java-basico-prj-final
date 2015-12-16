package br.com.lucasburg.form;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.com.lucasburg.handler.UsuarioSalvarCliqueHandler;

public class UsuarioForm extends JPanel {

	private static final long serialVersionUID = 1667250075246796632L;

	private final int HEIGHT = 25;
	private final int WIDTH_TXT = 220;

	public UsuarioForm() {
		super();
		super.setLayout(null);

		JLabel lblId = new JLabel("Id");
		lblId.setBounds(10, 10, 10, this.HEIGHT);
		super.add(lblId);

		JTextField txtId = new JTextField();
		txtId.setBounds(50, 10, this.WIDTH_TXT, this.HEIGHT);
		txtId.setEnabled(false);
		super.add(txtId);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 40, 40, this.HEIGHT);
		super.add(lblNome);

		JTextField txtNome = new JTextField();
		txtNome.setBounds(50, 40, this.WIDTH_TXT, this.HEIGHT);
		super.add(txtNome);

		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setBounds(10, 70, 40, this.HEIGHT);
		super.add(lblEmail);

		JTextField txtEmail = new JTextField();
		txtEmail.setBounds(50, 70, this.WIDTH_TXT, this.HEIGHT);
		super.add(txtEmail);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(10, 100, 100, this.HEIGHT);
		UsuarioSalvarCliqueHandler evento = new UsuarioSalvarCliqueHandler();
		btnSalvar.addActionListener(evento);
		super.add(btnSalvar);

	}
}
