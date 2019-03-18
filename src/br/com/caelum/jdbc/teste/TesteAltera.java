package br.com.caelum.jdbc.teste;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import br.com.caelum.jdbc.Contato;
import br.com.caelum.jdbc.dao.ContatoDao;

public class TesteAltera {

	public static void main(String[] args) {
		Contato contatoToBeUpdated = new Contato();
		ContatoDao contatoDao = new ContatoDao(); 
		contatoToBeUpdated.setId(10);
		contatoToBeUpdated.setNome("Adaão");
		contatoToBeUpdated.setEmail("a@a.com");
		contatoToBeUpdated.setEndereco("Vale do Silicio");
		contatoToBeUpdated.setDataNascimento(Calendar.getInstance());
		
		contatoDao.altera(contatoToBeUpdated);
		
		List<Contato> contatos = contatoDao.getLista();
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		
		for(Contato contato : contatos) {
			System.out.println("Nome: " + contato.getNome());
			System.out.println("Email: " + contato.getEmail());
			System.out.println("Endereco: " + contato.getEndereco());
			System.out.println("Data de nascimento: " + formato.format(contato.getDataNascimento().getTime()) + "\n");
		}

	}

}
