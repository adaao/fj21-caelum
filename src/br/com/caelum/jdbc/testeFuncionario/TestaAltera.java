package br.com.caelum.jdbc.testeFuncionario;

import br.com.caelum.jdbc.Funcionario;
import br.com.caelum.jdbc.dao.FuncionarioDao;
import br.com.caelum.jdbc.view.FuncionarioView;

public class TestaAltera {

	public static void main(String[] args) {
		Funcionario f = new Funcionario();
		FuncionarioDao fd = new FuncionarioDao();
		FuncionarioView fv = new FuncionarioView();
		
		f.setId(2);
		f.setNome("Raquel");
		f.setUsuario("RQ");
		f.setSenha("12345678");
		
		fd.altera(f);
		
		fv.imprimeFuncionarios(fd.lista());

	}

}
