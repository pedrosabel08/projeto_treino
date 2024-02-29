package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import modelo.Exercicio;
import java.sql.*;

public class ExercicioBD {
	Connection conn;
	PreparedStatement stmt;
	ResultSet rs;
	ArrayList<Exercicio> lista = new ArrayList<>();
	
	public ArrayList <Exercicio> pesquisarExercicio(){
		String sql = "select * from tb_exercicios";

		conn = new Conexao().faz_conexao();

		try {
			stmt =  conn.prepareStatement(sql);
			rs = stmt.executeQuery();


			while(rs.next()) {
				Exercicio exercicio = new Exercicio();
				exercicio.setId(rs.getInt("idtb_exercicios"));
				exercicio.setNomeExercicio(rs.getString("nomeExercicio"));
				exercicio.setSeries(rs.getInt("series"));
				exercicio.setReps(rs.getInt("reps"));
				exercicio.setTipo(rs.getString("tipoExercicio"));
				exercicio.setIdTreino(rs.getInt("id_treino"));

				lista.add(exercicio);

			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"Erro no Banco de Dados ao pesquisar o Exercicio -> " + e);
		}
		return lista;
	}
	
	public void cadastrarExercicio(Exercicio exercicio) {
		String sql = "insert into tb_exercicios (nomeExercicio, series, reps, tipoExercicio, id_treino) values (?,?,?,?,?)";
		
		conn = new Conexao().faz_conexao();
		
		try {
			
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, exercicio.getNomeExercicio());
			stmt.setInt(2, exercicio.getSeries());
			stmt.setInt(3, exercicio.getReps());
			stmt.setString(4, exercicio.getTipo());
			stmt.setInt(5, exercicio.getIdTreino());
			
			stmt.execute();
			stmt.close();
			
			JOptionPane.showMessageDialog(null, "Exercicio inserido com sucesso!");
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Preencha os campos para cadastrar!");
		}
		
	}

}
