package br.com.lucasburg.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.com.lucasburg.database.Adapter;
import br.com.lucasburg.mapper.UsuarioManipulationMapper;
import br.com.lucasburg.mapper.UsuarioSelectMapper;
import br.com.lucasburg.model.Usuario;

public class UsuarioFrame extends JFrame {
	private static final long serialVersionUID = 7747613308734722114L;
	private UsuarioSelectMapper mapper = null;
	private Connection adapter = null;
	private UsuarioManipulationMapper maniMapper = null;
	
	public UsuarioFrame() {
		super("Usuário");
		super.setSize(1000, 500);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		try {
			this.adapter    = Adapter.criar();
			this.mapper     = new UsuarioSelectMapper(this.adapter);
			this.maniMapper = new UsuarioManipulationMapper(this.adapter);
		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		UsuarioTableView table = new UsuarioTableView();
		
		try {
			table.setBounds(10, 80, 965, 370);
			table.load(mapper.fetchAll());
		} catch(Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
		/**
		 * Formulário
		 */
		JLabel label1 = new JLabel("Id");
		label1.setBounds(10, 10, 10, 20);
		panel.add(label1);
		JTextField field1 = new JTextField();
		field1.setBounds(30, 10, 200, 20);
		field1.setEnabled(false);
		panel.add(field1);
		
		JLabel label2 = new JLabel("Nome");
		label2.setBounds(240, 10, 50, 20);
		panel.add(label2);
		JTextField field2 = new JTextField();
		field2.setBounds(300, 10, 200, 20);
		panel.add(field2);
		
		JLabel label3 = new JLabel("E-mail");
		label3.setBounds(510, 10, 50, 20);
		panel.add(label3);
		JTextField field3 = new JTextField();
		field3.setBounds(570, 10, 200, 20);
		panel.add(field3);
		
		JButton btn1 = new JButton("Adicionar");
		btn1.setBounds(10, 40, 100, 20);
		
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Usuario model = new Usuario();
				model.setNome(field2.getText());
				model.setEmail(field3.getText());
				
				try {
					maniMapper.insert(model);
					table.load(mapper.fetchAll());
					JOptionPane.showMessageDialog(null, "Usuário adicionado");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (InstantiationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IllegalAccessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		panel.add(btn1);
		
		JButton btn2 = new JButton("Editar");
		btn2.setBounds(120, 40, 100, 20);
		
		btn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Usuario model = new Usuario();
				model.setId(Long.parseLong(field1.getText()));
				model.setNome(field2.getText());
				model.setEmail(field3.getText());
				try {
					maniMapper.update(model);
					table.load(mapper.fetchAll());
					JOptionPane.showMessageDialog(null, "O usuário foi alterado!");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		panel.add(btn2);
		
		JButton btn3 = new JButton("Deletar");
		btn3.setBounds(230, 40, 100, 20);
		
		btn3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Usuario model = new Usuario();
				model.setId(Long.parseLong(field1.getText()));
				
				try {
					maniMapper.delete(model);
					table.load(mapper.fetchAll());
					JOptionPane.showMessageDialog(null, "O usuário foi deletado.");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
			}
		});
		
		panel.add(btn3);
		
		
		/**
		 * Tabela
		 */
		
		
		
		
		table.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() == 2) {
					Usuario usuario = table.getUsuarioSelecionado();
					
					field1.setText(String.valueOf(usuario.getId()));
					field2.setText(usuario.getNome());
					field3.setText(usuario.getEmail());
					
				}
				
			}
		});
		
		
		panel.add(table);
		
		
		super.add(panel);
		super.setVisible(true);
		
		
	}

}
