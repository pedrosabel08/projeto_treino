package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import modelo.Treino;
import java.sql.*;

public class TreinoBD {
	Connection conn;
	PreparedStatement stmt;
	ResultSet rs;
	ArrayList<Treino> lista = new ArrayList<>();
	
	public ArrayList <Treino> pesquisarTreino(){
		String sql = "select * from Cliente";

		conn = new Conexao().faz_conexao();

		try {
			stmt =  conn.prepareStatement(sql);
			rs = stmt.executeQuery();


			while(rs.next()) {
				Treino treino = new Treino();
				treino.setId(rs.getInt("idtb_treinos"));
				treino.setData(rs.getString("data"));
				treino.setNomeTreino(rs.getString("nomeTreino"));
				treino.setIdUsuario(rs.getInt("id_usuario"));

				lista.add(treino);

			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"Erro no Banco de Dados ao pesquisar o Cliente -> " + e);
		}
		return lista;
	}
	
	public void cadastrarTreino(Treino treino) {
		String sql = "insert into tb_treinos (data, nomeTreino, id_usuario) values (?,?,?)";
		
		conn = new Conexao().faz_conexao();
		
		try {
			
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, treino.getData());
			stmt.setString(2, treino.getNomeTreino());
			stmt.setInt(3, treino.getIdUsuario());
			
			stmt.execute();
			stmt.close();
			
			JOptionPane.showMessageDialog(null, "Cliente inserido com sucesso!");
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Preencha os campos para cadastrar!");
		}
		
	}

}
