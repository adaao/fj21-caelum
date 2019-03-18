package br.com.caelum.jdbc.testeFuncionario;

import br.com.caelum.jdbc.dao.FuncionarioDao;
import br.com.caelum.jdbc.view.FuncionarioView;

public class TestaRemove {

	public static void main(String[] args) {
		FuncionarioDao fd = new FuncionarioDao();
		FuncionarioView fv = new FuncionarioView();
		
		fd.remove(1);
		
		fv.imprimeFuncionarios(fd.lista());

	}

}
