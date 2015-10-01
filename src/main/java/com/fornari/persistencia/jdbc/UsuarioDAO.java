package com.fornari.persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.fornari.persistencia.entidade.Usuario;

public class UsuarioDAO {
	
	private Connection conexao = ConexaoFactory.getConnection(); 
			
	public void cadastrar(Usuario usuario) {
		String sql = "insert into usuario (nome, login, senha) values (?, ?, ?)";
		
		try (PreparedStatement preparador = conexao.prepareStatement(sql)){
			//Obs: ao utilizar o try com parâmeto não precisa fechar o objeto que implementa closeable
			//Criando um Statement
			//PreparedStatement preparador = conexao.prepareStatement(sql);
			preparador.setString(1, usuario.getNome());
			preparador.setString(2, usuario.getLogin());
			preparador.setString(3, usuario.getSenha());
			//Executando no bd
			preparador.execute();
			
			//Fechando o preparador.
			//preparador.close();
			
		}catch (SQLException e){
			e.printStackTrace();
		}
	}

	public void alterar(Usuario usuario) {
		String sql = "update usuario set nome=?, login=?, senha=? where id=?";
		
		try (PreparedStatement preparador = conexao.prepareStatement(sql)){
			preparador.setString(1, usuario.getNome());
			preparador.setString(2, usuario.getLogin());
			preparador.setString(3, usuario.getSenha());
			preparador.setInt(4, usuario.getId());
			//Executando no bd
			preparador.execute();
			
		}catch (SQLException e){
			e.printStackTrace();
		}
		
	}

	public void excluir(Usuario usuario) {
		String sql = "delete from usuario where id=?";
		
		try (PreparedStatement preparador = conexao.prepareStatement(sql)){
			preparador.setInt(1, usuario.getId());
			//Executando no bd
			preparador.execute();
			
		}catch (SQLException e){
			e.printStackTrace();
		}
		
	}
	
	

}
