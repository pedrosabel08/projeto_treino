package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import modelo.Usuario;
import java.sql.*;

public class UsuarioBD {
	Connection conn;
	PreparedStatement stmt;
	ResultSet rs;
	ArrayList<Usuario> lista = new ArrayList<>();
	
	public ArrayList <Usuario> pesquisarUsuario(){
		String sql = "select idtb_usuario, nomeUsuario from tb_usuario";

		conn = new Conexao().faz_conexao();

		try {
			stmt =  conn.prepareStatement(sql);
			rs = stmt.executeQuery();


			while(rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setId(rs.getInt("idtb_usuario"));
				usuario.setNomeUsuario(rs.getString("nomeUsuario"));

				lista.add(usuario);

			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"Erro no Banco de Dados ao pesquisar o Usuario -> " + e);
		}
		return lista;
	}
	
}
