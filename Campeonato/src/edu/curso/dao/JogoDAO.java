package edu.curso.dao;

import java.util.Date;
import java.util.List;

import edu.curso.entidade.Jogo;

public interface JogoDAO {

	public void adicionar(Jogo j);
	public void remover(Jogo j);
	public void atualizar(long rg, Jogo j);
	public Jogo pesquisarPorRegistro(String rg);
	public List<Jogo> pesquisarPorData(Date d);
	public List<Jogo> pesquisarTodos();
	public List<Jogo> pesquisarPorFase(String fase);
	
}
