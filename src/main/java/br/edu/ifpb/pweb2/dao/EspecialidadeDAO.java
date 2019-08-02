package br.edu.ifpb.pweb2.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.jboss.logging.Logger;

import br.edu.ifpb.pweb2.model.Especialidade;
import br.edu.ifpb.pweb2.model.User;

public class EspecialidadeDAO extends GenericDAOJPAImpl<Especialidade, Long>  {
	
	private static Logger logger = Logger.getLogger(EspecialidadeDAO.class);
	
	public EspecialidadeDAO() {}
	
	public EspecialidadeDAO(EntityManager em) {
		super(em); 
	}
	
	@SuppressWarnings("unchecked")
	public List<Especialidade> findAll() {
		Query q = entityManager.createQuery("from Especialidade e");
		return q.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public Especialidade findByName(String nameEsp) {
		Query q = entityManager.createQuery("from Especialidade e where e.nome = :nameEsp");
		q.setParameter("nameEsp", nameEsp);
		Especialidade esp = null;
		try {
			esp = (Especialidade) q.getSingleResult();
		}catch (NoResultException e) {		
		}
		return esp; 
	}

}
