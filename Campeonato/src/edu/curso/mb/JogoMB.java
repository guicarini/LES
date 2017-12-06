package edu.curso.mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import edu.curso.dao.JogoDAO;
import edu.curso.dao.JogoDAOImplementation;
import edu.curso.entidade.Jogo;

@ManagedBean
@ViewScoped
public class JogoMB implements Serializable {

	private static final long serialVersionUID = 1402178303413714619L;
	private Jogo jogoAtual;
	private List<Jogo> jogos;
	private String selecao;
	
	public JogoMB() { 
		setJogoAtual( new Jogo() );
		setJogos( new ArrayList<Jogo>() );
	}
	
	public String remover() {
		
		FacesContext.getCurrentInstance()
		.addMessage(null, 
		new FacesMessage("Jogo com Registro " + 
							jogoAtual.getRg() + 
							" foi removido com sucesso") );

		
		JogoDAO aDao = new JogoDAOImplementation();
		aDao.remover( jogoAtual );
				
		return " ";
	}
	
	public String adicionar() { 
		JogoDAO aDao = new JogoDAOImplementation();
		aDao.adicionar( jogoAtual );
		
		FacesContext.getCurrentInstance()
			.addMessage(null, 
			new FacesMessage("Jogo " + 
								jogoAtual.getRg() + 
								" cadastrado com sucesso") );
		
		jogoAtual = new Jogo();
		return " ";
	}
	
	public String atualizar() { 
		JogoDAO aDao = new JogoDAOImplementation();
		aDao.atualizar( jogoAtual.getRg(), jogoAtual );
		
		FacesContext.getCurrentInstance()
			.addMessage(null, 
			new FacesMessage("Jogo " + 
								jogoAtual.getRg() + 
								" atualizado com sucesso") );
		
		//jogoAtual = new Jogo();
		return " ";
	}
	
	public String pesquisar() {
		JogoDAO aDao = new JogoDAOImplementation();
		if ("todos".equals(selecao)) { 
			jogos = aDao.pesquisarTodos();
		} else if ("porfase".equals(selecao)) { 
			jogos = aDao.pesquisarPorFase( jogoAtual.getFase() );
		} else if ("pordata".equals(selecao)) { 
			jogos = aDao.pesquisarPorData( jogoAtual.getData() );
		}
		return " ";
	}
	
	public Jogo getJogoAtual() {
		return jogoAtual;
	}
	public void setJogoAtual(Jogo jogoAtual) {
		this.jogoAtual = jogoAtual;
	}
	public List<Jogo> getJogos() {
		return jogos;
	}
	public void setJogos(List<Jogo> jogos) {
		this.jogos = jogos;
	}

	public String getSelecao() {
		return selecao;
	}

	public void setSelecao(String selecao) {
		this.selecao = selecao;
	}

	public String adicionar1() { 
		JogoDAO aDao = new JogoDAOImplementation();
		aDao.adicionar( jogoAtual );
		
		FacesContext.getCurrentInstance()
			.addMessage(null, 
			new FacesMessage("Jogo " + 
								jogoAtual.getRg() + 
								" cadastrado com sucesso") );
		
		jogoAtual = new Jogo();
		return " ";
	}	
}
