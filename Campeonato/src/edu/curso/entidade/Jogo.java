package edu.curso.entidade;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="jogos")
public class Jogo implements Serializable {
	private static final long serialVersionUID = -6984028578561425302L;
	
	private long rg;
	private String fase;
	private String adversario;
	private Date data;
	
	@Id
	@GeneratedValue
	public long getRg() {
		return rg;
	}
	public void setRg(long rg) {
		this.rg = rg;
	}
	
	@Column(length=50)
	public String getFase() {
		return fase;
	}
	public void setFase(String fase) {
		this.fase = fase;
	}
	
	@Column(length=100)
	public String getAdversario() {
		return adversario;
	}
	public void setAdversario(String adversario) {
		this.adversario = adversario;
	}	
	
	@Column
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
}
