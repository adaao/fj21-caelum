package br.com.caelum.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.caelum.jdbc.ConnectionFactory;
import br.com.caelum.jdbc.Funcionario;
import br.com.caelum.jdbc.exceptions.DAOException;

public class FuncionarioDao implements Dao {
	private Connection connection;
	
	public FuncionarioDao() {
		this.connection = new ConnectionFactory().getConnection();
	}

	public void adiciona(Funcionario funcionario) {
		String sql = "INSERT INTO funcionarios "
				   		+ "(nome, usuario, senha) "
				   + "VALUES "
				   		+ "(?, ?, ?); ";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, funcionario.getNome());
			stmt.setString(2, funcionario.getUsuario());
			stmt.setString(3, funcionario.getSenha());
			stmt.execute();
			stmt.close();
					
			
		} catch (SQLException e) {
			throw new DAOException (e);
		}

	}

	@Override
	public void remove(long id) {
		String sql = "delete from funcionarios where id = ?";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, id);
			stmt.execute();
			stmt.close();
		}catch(SQLException e) {
			throw new DAOException (e);
		}

	}

	public void altera(Funcionario f) {
		String sql = "UPDATE funcionarios SET "
				   + "nome = ?, "
				   + "usuario = ?, "
				   + "senha = ? "
				   + "WHERE id = ?;";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, f.getNome());
			stmt.setString(2, f.getUsuario());
			stmt.setString(3, f.getSenha());
			stmt.setLong(4, f.getId());
			
			stmt.execute();
			stmt.close();
		}catch(SQLException e) {
			throw new DAOException (e);
		}

	}

	@Override
	public List<Funcionario> lista() {
		try {
			List<Funcionario> funcionarios = new ArrayList<Funcionario>();
			String sql = "SELECT * FROM funcionarios;"; 
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while(rs.next()) {
				funcionarios.add(
					funcionarioFactoyFromResultSet(rs)
				);
			}
			rs.close();
			stmt.close();
			return funcionarios;
		}catch (SQLException e) {
			throw new DAOException(e);
		}
	}
	
	private Funcionario funcionarioFactoyFromResultSet(ResultSet rs) throws SQLException {
		Funcionario funcionario = new Funcionario();
		
		funcionario.setId(rs.getLong("id"));
		funcionario.setNome(rs.getString("nome"));
		funcionario.setUsuario(rs.getString("usuario"));
		funcionario.setSenha(rs.getString("senha"));
		
		return funcionario;
	}

	
	@Override
	public void adiciona() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void altera() {
		// TODO Auto-generated method stub
		
	}


}
