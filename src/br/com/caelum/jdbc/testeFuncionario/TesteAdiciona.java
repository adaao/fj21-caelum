package br.com.caelum.jdbc.testeFuncionario;

import br.com.caelum.jdbc.Funcionario;
import br.com.caelum.jdbc.dao.FuncionarioDao;
import br.com.caelum.jdbc.view.FuncionarioView;

public class TesteAdiciona {

	public static void main(String[] args) {
		Funcionario f = new Funcionario();
		FuncionarioDao fd = new FuncionarioDao();
		FuncionarioView fv = new FuncionarioView();
		
		f.setNome("Adaao");
		f.setUsuario("adaao");
		f.setSenha("nada");
		
		fd.adiciona(f);
		
		fv.imprimeFuncionarios(fd.lista());
		
		

	}

}
