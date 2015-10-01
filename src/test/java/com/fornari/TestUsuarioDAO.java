package com.fornari;

import com.fornari.persistencia.entidade.Usuario;
import com.fornari.persistencia.jdbc.UsuarioDAO;

public class TestUsuarioDAO {

	public static void main(String[] args) {
		
		testExcluir();
	}
	
	public static void testCadastrar(){
		//Criando o usuário
		Usuario usuario = new Usuario();
		usuario.setNome("Roberto");
		usuario.setLogin("roberto");
		usuario.setSenha("123456");
		//Cadastrando o usuario no bd
		UsuarioDAO usuDAO = new UsuarioDAO();
		usuDAO.cadastrar(usuario);
		
		System.out.println("Cadastrado com sucesso!");
	}
	
	public static void testAlterar(){
		//Criando o usuário
		Usuario usuario = new Usuario();
		usuario.setId(3);
		usuario.setNome("Roberto");
		usuario.setLogin("betim");
		usuario.setSenha("456789");
		//Cadastrando o usuario no bd
		UsuarioDAO usuDAO = new UsuarioDAO();
		usuDAO.alterar(usuario);
		
		System.out.println("Alterado com sucesso!");
	}
	
	public static void testExcluir(){
		//Criando o usuário
		Usuario usuario = new Usuario();
		usuario.setId(3);

		//Cadastrando o usuario no bd
		UsuarioDAO usuDAO = new UsuarioDAO();
		usuDAO.excluir(usuario);
		
		System.out.println("Excluido com sucesso!");
	}

}
