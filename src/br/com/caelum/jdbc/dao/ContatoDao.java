package br.com.caelum.jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.caelum.jdbc.ConnectionFactory;
import br.com.caelum.jdbc.Contato;
import br.com.caelum.jdbc.exceptions.DAOException;

public class ContatoDao {
	private Connection connection;
	
	public ContatoDao() {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void adiciona(Contato contato) {
		String sql = "INSERT INTO contatos" + 
						"(nome, email, endereco, dataNascimento)" + 
					"VALUES " + 
						"(?,?,?,?)";
				
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date(
					contato.getDataNascimento().getTimeInMillis()));
			
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			throw new DAOException(e);
		}
			
	}
	
	public List<Contato> getLista() {
		try {
			List<Contato> contatos = new ArrayList<Contato>();
			String sql = "SELECT * FROM contatos;"; 
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while(rs.next()) {
				contatos.add(
					contatoFactoyFromResultSet(rs)
				);
			}
			rs.close();
			stmt.close();
			return contatos;
		}catch (SQLException e) {
			throw new DAOException(e);
		}
	}
	
	private Contato contatoFactoyFromResultSet(ResultSet rs) throws SQLException {
		Contato contato = new Contato();
		Calendar data = Calendar.getInstance();
		
		contato.setId(rs.getLong("id"));
		contato.setNome(rs.getString("nome"));
		contato.setEmail(rs.getString("email"));
		contato.setEndereco(rs.getString("endereco"));
		data.setTime(rs.getDate("dataNascimento"));
		contato.setDataNascimento(data);
		
		return contato;
	}
	
	public List<Contato> getListByFirstLetter(char a) {
		try {
			List<Contato> contatos = new ArrayList<Contato>();
			String sql = "SELECT * FROM contatos WHERE nome LIKE '" + a + "%';"; 
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while(rs.next()) {
				contatos.add(
					contatoFactoyFromResultSet(rs)
				);
			}
			rs.close();
			stmt.close();
			return contatos;
		}catch (SQLException e) {
			throw new DAOException(e);
		}
	}
	
	public void altera(Contato contato) {
		String sql = "UPDATE contatos SET "
				   + "nome = ?, "
				   + "email = ?, "
				   + "endereco = ?,"
				   + "dataNascimento = ?"
				   + "WHERE id = ?;";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date(
					contato.getDataNascimento()
					.getTimeInMillis()
				)
			);
			stmt.setLong(5, contato.getId());
			stmt.execute();
			stmt.close();
		}catch (SQLException  e){
			throw new RuntimeException(e);
		}
				   
	}
	
	public void remove(Contato contato) {
		String sql = "DELETE FROM contatos WHERE id = ?;";
		try {
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			
			stmt.setLong(1, contato.getId());
			
			stmt.execute();
			stmt.close();
		}catch(SQLException e) {
			throw new DAOException(e);
		}
	}
	
	public void remove(long contatoId) {
		String sql = "DELETE FROM contatos WHERE id = ?";
		
		try {
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setLong(1, contatoId);
			stmt.execute();
			stmt.close();
		}catch(SQLException e) {
			throw new DAOException(e);
		}
	}
	
}
