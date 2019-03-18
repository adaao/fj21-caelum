package br.com.caelum.jdbc.dao;

import java.util.List;

public interface Dao {
	public void adiciona();
	
	public void remove(long id);
	
	public void altera();
	
	public List lista();
}
