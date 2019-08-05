package br.edu.ifpb.pweb2.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.jboss.logging.Logger;

import br.edu.ifpb.pweb2.model.Especialidade;
import br.edu.ifpb.pweb2.model.Evento;

public class EventoDAO extends GenericDAOJPAImpl<Evento, Long>  {

private static Logger logger = Logger.getLogger(EspecialidadeDAO.class);
	
	public EventoDAO() {}
	
	public EventoDAO(EntityManager em) {
		super(em); 
	}
	
	@SuppressWarnings("unchecked")
	public Evento findByName(String nameEvento) {
		Query q = entityManager.createQuery("from Evento e where e.nome = :nameEvento");
		q.setParameter("nameEvento", nameEvento);
		Evento evento = null;
		try {
			evento = (Evento) q.getSingleResult();
		}catch (NoResultException e) {		
			return null;
		}
		return evento; 
	}
	
	@SuppressWarnings("unchecked")
	public List<Evento> findAll() {
		Query q = entityManager.createQuery("from Evento e");
		return q.getResultList();
	}
	
	public List<Especialidade> findEspecialidadesByEvento(Long idevento) {
		Query query = entityManager.createQuery("select e from Especialidade e LEFT JOIN e.vagas v  LEFT JOIN v.evento ev  where ev.id = :idevento", Especialidade.class);
		query.setParameter("idevento", idevento);
		try {
			List<Especialidade> especialidades = (List<Especialidade>)query.getResultList();
			return especialidades;
		} catch (Exception e) {
			return null;
		}
	}

	
	
}
