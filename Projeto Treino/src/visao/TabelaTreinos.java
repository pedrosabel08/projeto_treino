package visao;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;

import modelo.Treino;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controle.TreinoBD;

public class TabelaTreinos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tbTreinos;
	private ArrayList<Treino> listaTreinos;
	private Treino treinoSelecionado;
	private DefaultTableModel modelo;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public TabelaTreinos(TelaCadastros ta) {
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
				
				tbTreinos = new JTable();
				tbTreinos.setForeground(Color.WHITE);
				tbTreinos.setBackground(Color.DARK_GRAY);
				tbTreinos.setFont(new Font("Tahoma", Font.PLAIN, 14));
				tbTreinos.setModel(new DefaultTableModel(new Object[][] {
					
				}, new String[] { "ID", "Nome", }

				));
				scrollPane.setViewportView(tbTreinos);
				
				modelo = (DefaultTableModel) tbTreinos.getModel();
				tbTreinos.setModel(modelo);
				
				TreinoBD treinoBD = new TreinoBD();
				
				listaTreinos = treinoBD.pesquisarTreino();
				for (int i = 0; i < listaTreinos.size(); i++) {
					Treino t = listaTreinos.get(i);
					modelo.addRow(new Object[] { t.getId(), t.getNomeTreino() });

				}
				tbTreinos.addMouseListener(new MouseAdapter() {
				    @Override
				    public void mouseClicked(MouseEvent e) {
				        if (e.getClickCount() == 1) {
				           
				            int linha = tbTreinos.getSelectedRow();
				            int idTreino = (int) tbTreinos.getValueAt(linha, 0);
				            
				            for (Treino treino : listaTreinos) {
				            	if (treino.getId() == idTreino) {
									treinoSelecionado = treino;
								}
								
							}
				            if (linha != -1) {
				                ta.setTreinoSelecionado(treinoSelecionado);
				                dispose();
				               
				                
				            } else {
				            	JOptionPane.showMessageDialog(null, "escolha uma linha");
				            }
				        }
				    }
				});
	}

}
