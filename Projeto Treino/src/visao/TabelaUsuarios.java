package visao;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;

import modelo.Usuario;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controle.UsuarioBD;

public class TabelaUsuarios extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tbUsuarios;
	private ArrayList<Usuario> listaUsuarios;
	private Usuario usuarioSelecionado;
	private DefaultTableModel modelo;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public TabelaUsuarios(TelaCadastros ta) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 50, 430, 174);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
				JScrollPane scrollPane = new JScrollPane();
				panel.add(scrollPane);
				
				tbUsuarios = new JTable();
				tbUsuarios.setForeground(Color.WHITE);
				tbUsuarios.setBackground(Color.DARK_GRAY);
				tbUsuarios.setFont(new Font("Tahoma", Font.PLAIN, 14));
				tbUsuarios.setModel(new DefaultTableModel(new Object[][] {
					
				}, new String[] { "ID", "Nome", }

				));
				scrollPane.setViewportView(tbUsuarios);
				
				modelo = (DefaultTableModel) tbUsuarios.getModel();
				tbUsuarios.setModel(modelo);
				
				UsuarioBD usuarioBD = new UsuarioBD();
				
				listaUsuarios = usuarioBD.pesquisarUsuario();
				for (int i = 0; i < listaUsuarios.size(); i++) {
					Usuario u = listaUsuarios.get(i);
					modelo.addRow(new Object[] { u.getId(), u.getNomeUsuario() });

				}
				tbUsuarios.addMouseListener(new MouseAdapter() {
				    @Override
				    public void mouseClicked(MouseEvent e) {
				        if (e.getClickCount() == 1) {
				           
				            int linha = tbUsuarios.getSelectedRow();
				            int idUsuario = (int) tbUsuarios.getValueAt(linha, 0);
				            
				            for (Usuario usuario : listaUsuarios) {
				            	if (usuario.getId() == idUsuario) {
									usuarioSelecionado = usuario;
								}
								
							}
				            if (linha != -1) {
				                ta.setUsuarioSelecionado(usuarioSelecionado);
				                dispose();
				               
				                
				            } else {
				            	JOptionPane.showMessageDialog(null, "escolha uma linha");
				            }
				        }
				    }
				});
	}

}
