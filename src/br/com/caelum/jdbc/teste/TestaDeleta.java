package br.com.caelum.jdbc.teste;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.view.ContatoView;

public class TestaDeleta {

	public static void main(String[] args) {
		ContatoDao dao = new ContatoDao();
		ContatoView view = new ContatoView();
		
		long id = 5;
		
		dao.remove(id);
		
		view.imprimeContatos();

	}

}
