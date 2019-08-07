package br.edu.ifpb.pweb2.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.jboss.logging.Logger;

import br.edu.ifpb.pweb2.model.Vaga;

public class VagaDAO extends GenericDAOJPAImpl<Vaga, Long>  {
	private static Logger logger = Logger.getLogger(EspecialidadeDAO.class);
	
	public VagaDAO() {};
	
	public VagaDAO(EntityManager em) {
		super(em); 
	}

	
	@SuppressWarnings("unchecked")
	public List<Vaga> findAll() {
		Query q = entityManager.createQuery("from Vaga e");
		return q.getResultList();
	}

}
