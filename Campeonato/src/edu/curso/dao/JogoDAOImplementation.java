package edu.curso.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import edu.curso.entidade.Jogo;

public class JogoDAOImplementation 
		implements JogoDAO {

	@Override
	public void adicionar(Jogo j) {
		EntityManager em = JPAUtil.getEntityManager();
		
		em.getTransaction().begin();
		em.persist( j );
		em.getTransaction().commit();
		
		em.close();
		
		
	}
	@Override
	public void remover(Jogo j) {
		EntityManager em = JPAUtil.getEntityManager();
		
		em.getTransaction().begin();
		em.remove( j );
		em.getTransaction().commit();
		
		em.close();
	}

	@Override
	public void atualizar(long rg, Jogo j) {
		EntityManager em = JPAUtil.getEntityManager();
		Jogo oldJogo = em.getReference(Jogo.class, rg);
		if (oldJogo != null) { 
			em.getTransaction().begin();
			oldJogo.setAdversario( j.getAdversario() );
			oldJogo.setFase( j.getFase() );
			oldJogo.setRg( j.getRg() );
			oldJogo.setData( j.getData() );
			em.getTransaction().commit();
		}
		em.close();
	}

	@Override
	public Jogo pesquisarPorRegistro(String rg) {
		EntityManager em = JPAUtil.getEntityManager();
		TypedQuery<Jogo> qry = em.
			createQuery("select a from jogos j where j.rg = :r", 
						Jogo.class);
			qry.setParameter("r", rg);
		Jogo j = qry.getSingleResult();
		if (j == null) {
			j = new Jogo();
		}
		em.close();
		return j;
	}

	@Override
	public List<Jogo> pesquisarPorData(Date data) {
		EntityManager em = JPAUtil.getEntityManager();
		TypedQuery<Jogo> qry = em.
			createQuery("select j from jogos j where j.data = :d", 
						Jogo.class);
			qry.setParameter("d", data);
		List<Jogo> lista = qry.getResultList();
		if (lista == null) {
			lista = new ArrayList<Jogo>();
		}
		em.close();
		return lista;
	}

	@Override
	public List<Jogo> pesquisarTodos() {
		EntityManager em = JPAUtil.getEntityManager();
		TypedQuery<Jogo> qry = em.
				createQuery("select j from jogos j", Jogo.class);
		List<Jogo> lista = qry.getResultList();
		if (lista == null) {
			lista = new ArrayList<Jogo>();
		}
		em.close();
		return lista;
	}

	@Override
	public List<Jogo> pesquisarPorFase(String fase) {
		EntityManager em = JPAUtil.getEntityManager();
		TypedQuery<Jogo> qry = em.
			createQuery("select j from jogos j where j.fase like :f", 
						Jogo.class);
			qry.setParameter("f", fase);
		List<Jogo> lista = qry.getResultList();
		if (lista == null) {
			lista = new ArrayList<Jogo>();
		}
		em.close();
		return lista;
	}

}
