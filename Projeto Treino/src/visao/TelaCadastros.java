package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;

import java.awt.*;
import java.util.*;
import java.text.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

import modelo.Usuario;
import modelo.Treino;
import modelo.Exercicio;
import controle.ExercicioBD;
import controle.TreinoBD;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class TelaCadastros extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNomeUsuario;

	private Usuario usuarioSelecionado;
	private Treino treinoSelecionado;
	private Exercicio exercicioSelecionado;
	private JTextField txtNomeExercicio;
	private JTextField txtSeries;
	private JTextField txtTipo;
	private JTextField txtNomeTreino;
	private JLabel lblHora;
	private JTextField txtRep;
	private JTextField txtIDTreino;
	private JTextField txtIdUsuario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastros frame = new TelaCadastros();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public void setUsuarioSelecionado(Usuario usuario) {
		this.usuarioSelecionado = usuario;
		this.txtIdUsuario.setText(String.valueOf(usuario.getId()));
		this.txtNomeUsuario.setText(usuario.getNomeUsuario());
		this.txtIDUsuario.setText(String.valueOf(usuario.getId()));
	
	}
	public void setTreinoSelecionado(Treino treino) {
		this.treinoSelecionado = treino;
		this.txtIDTreino.setText(String.valueOf(treino.getId()));
		this.txtNomeTreino.setText(treino.getNomeTreino());

	}
	public void setExercicioSelecionado(Exercicio exercicio) {
		this.exercicioSelecionado = exercicio;
		this.txtNomeExercicio.setText(exercicio.getNomeExercicio());
		this.txtSeries.setText(String.valueOf(exercicio.getSeries()));
		this.txtTipo.setText(exercicio.getTipo());
		this.txtRep.setText(String.valueOf(exercicio.getReps()));
		
	}
	/**
	 * Create the frame.
	 */
	public TelaCadastros () {
		TelaCadastros ta = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
	


		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cadastro de Treinos");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 25));
		lblNewLabel.setBounds(50, 10, 240, 52);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ID Aluno:");
		lblNewLabel_1.setBounds(10, 184, 101, 31);
		contentPane.add(lblNewLabel_1);
		
		txtIdUsuario = new JTextField();
		txtIdUsuario.setEditable(false);
		txtIdUsuario.setBounds(10, 226, 86, 20);
		contentPane.add(txtIdUsuario);
		txtIdUsuario.setColumns(10);
		

		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 184, 101, 31);
		contentPane.add(lblNewLabel_1);
		
		JButton btnAlunos = new JButton("Alunos");
		btnAlunos.setFont(new Font("Arial", Font.PLAIN, 15));
		btnAlunos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TabelaUsuarios TU = new TabelaUsuarios(ta);
				TU.setVisible(true);
			}
		});
		btnAlunos.setBounds(97, 188, 89, 23);
		contentPane.add(btnAlunos);
		btnAlunos.setBounds(118, 188, 89, 25);
		contentPane.add(btnAlunos);
		
		JLabel lblNomeAluno = new JLabel("Nome Aluno:");
		lblNomeAluno.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNomeAluno.setBounds(10, 270, 101, 31);
		contentPane.add(lblNomeAluno);
		
		JLabel lblNewLabel_1_2 = new JLabel("Nome Exerc\u00EDcio:");
		lblNewLabel_1_2.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_1_2.setBounds(244, 301, 123, 31);
		contentPane.add(lblNewLabel_1_2);
		
		txtNomeExercicio = new JTextField();
		txtNomeExercicio.setFont(new Font("Arial", Font.PLAIN, 15));
		txtNomeExercicio.setBounds(377, 301, 167, 25);
		contentPane.add(txtNomeExercicio);
		txtNomeExercicio.setColumns(10);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("S\u00E9ries:");
		lblNewLabel_1_2_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_1_2_1.setBounds(244, 426, 101, 31);
		contentPane.add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_2_3 = new JLabel("Tipo:");
		lblNewLabel_1_2_3.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_1_2_3.setBounds(244, 491, 101, 31);
		contentPane.add(lblNewLabel_1_2_3);
		
		txtSeries = new JTextField();
		txtSeries.setFont(new Font("Arial", Font.PLAIN, 15));
		txtSeries.setColumns(10);
		txtSeries.setBounds(321, 431, 86, 25);
		contentPane.add(txtSeries);
		
		txtTipo = new JTextField();
		txtTipo.setFont(new Font("Arial", Font.PLAIN, 15));
		txtTipo.setColumns(10);
		txtTipo.setBounds(321, 496, 86, 25);
		contentPane.add(txtTipo);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("Nome Treino:");
		lblNewLabel_1_2_2.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_1_2_2.setBounds(245, 188, 101, 31);
		contentPane.add(lblNewLabel_1_2_2);
		
		txtNomeTreino = new JTextField();
		txtNomeTreino.setFont(new Font("Arial", Font.PLAIN, 15));
		txtNomeTreino.setColumns(10);
		txtNomeTreino.setBounds(378, 193, 167, 25);
		contentPane.add(txtNomeTreino);
		
		lblHora = new JLabel("");
		lblHora.setHorizontalAlignment(SwingConstants.CENTER);
		lblHora.setFont(new Font("Arial", Font.PLAIN, 20));
		lblHora.setBounds(754, 441, 167, 50);
		contentPane.add(lblHora);
		
		LocalDateTime dataAtual = LocalDateTime.now();
		DateTimeFormatter form = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		String dataForm = dataAtual.format(form);	
		lblHora.setText(dataForm);
	
		txtNomeUsuario = new JTextField();
		txtNomeUsuario.setEditable(false);
		txtNomeUsuario.setFont(new Font("Arial", Font.PLAIN, 15));
		txtNomeUsuario.setColumns(10);
		txtNomeUsuario.setBounds(10, 312, 86, 25);
		contentPane.add(txtNomeUsuario);
		
		JButton btnCadastrarTreino = new JButton("Cadastrar Treino");
		btnCadastrarTreino.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String idUsuario = txtIdUsuario.getText();
				String nomeTreino = txtNomeTreino.getText();
				DateTimeFormatter dtf5 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				String date =(dtf5.format(LocalDateTime.now()));
				
				Treino treino = new Treino();
				
				treino.setNomeTreino(nomeTreino);
				treino.setData(date);						
				treino.setIdUsuario(Integer.valueOf(idUsuario));
				
				TreinoBD treinoBD = new TreinoBD();
				treinoBD.cadastrarTreino(treino);
				

				JOptionPane.showMessageDialog(null, "Treino Cadastrado!");

				txtIdUsuario.setText("");

				txtNomeTreino.setText("");
				txtNomeUsuario.setText("");
				
			}
		});
		btnCadastrarTreino.setFont(new Font("Arial", Font.PLAIN, 18));
		btnCadastrarTreino.setBounds(716, 189, 205, 50);
		contentPane.add(btnCadastrarTreino);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("Repeti\u00E7\u00F5es:");
		lblNewLabel_1_2_1_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_1_2_1_1.setBounds(244, 364, 101, 31);
		contentPane.add(lblNewLabel_1_2_1_1);
		
		txtRep = new JTextField();
		txtRep.setFont(new Font("Arial", Font.PLAIN, 15));
		txtRep.setColumns(10);
		txtRep.setBounds(345, 367, 86, 25);
		contentPane.add(txtRep);
		
		JButton btnCadastrarExercicio = new JButton("Cadastrar Exercicio");
		btnCadastrarExercicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nomeExercicio = txtNomeExercicio.getText();
				String series = txtSeries.getText();
				String reps = txtRep.getText();
				String tipo = txtTipo.getText();
				String idTreino = txtIDTreino.getText();
				
				Exercicio exercicio = new Exercicio();
				exercicio.setNomeExercicio(nomeExercicio);
				exercicio.setSeries(Integer.valueOf(series));
				exercicio.setReps(Integer.valueOf(reps));
				exercicio.setTipo(tipo);
				exercicio.setIdTreino(Integer.valueOf(idTreino));
				
				ExercicioBD exBD = new ExercicioBD();
				exBD.cadastrarExercicio(exercicio);
				
				txtIdUsuario.setText("");
				txtNomeTreino.setText("");
				txtNomeUsuario.setText("");
				txtNomeExercicio.setText("");
				txtSeries.setText("");
				txtRep.setText("");
				txtTipo.setText("");
				txtIDTreino.setText("");
			}
		});
		btnCadastrarExercicio.setFont(new Font("Arial", Font.PLAIN, 18));

		btnCadastrarExercicio.setBounds(716, 293, 205, 50);
		contentPane.add(btnCadastrarExercicio);
		
		JLabel lblNewLabel_1_3 = new JLabel("ID Treino:");
		lblNewLabel_1_3.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_1_3.setBounds(245, 244, 101, 31);
		contentPane.add(lblNewLabel_1_3);
		
		txtIDTreino = new JTextField();
		txtIDTreino.setFont(new Font("Arial", Font.PLAIN, 15));
		txtIDTreino.setColumns(10);
		txtIDTreino.setBounds(334, 246, 86, 25);
		contentPane.add(txtIDTreino);
		
		txtIdUsuario = new JTextField();
		txtIdUsuario.setFont(new Font("Arial", Font.PLAIN, 15));
		txtIdUsuario.setEditable(false);
		txtIdUsuario.setColumns(10);
		txtIdUsuario.setBounds(10, 234, 86, 25);
		contentPane.add(txtIdUsuario);
		
		JButton btnTreinos = new JButton("Treinos");
		btnTreinos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TabelaTreinos tt = new TabelaTreinos(ta);
				tt.setVisible(true);
			}
		});
		btnTreinos.setFont(new Font("Arial", Font.PLAIN, 15));
		btnTreinos.setBounds(456, 249, 89, 25);
		contentPane.add(btnTreinos);
		
	}
}
