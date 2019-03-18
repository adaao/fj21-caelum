package br.com.caelum.jdbc.view;

import java.util.List;

import br.com.caelum.jdbc.Funcionario;

public class FuncionarioView {
	public void imprimeFuncionarios(List<Funcionario> funcionarios) {
		for(Funcionario f : funcionarios) {
			System.out.println("id: " + f.getId());
			System.out.println("Nome: " + f.getNome());
			System.out.println("Usuario: " + f.getUsuario());
			System.out.println("Senha: " + f.getSenha());
			System.out.println();
			
		}
	}
}
