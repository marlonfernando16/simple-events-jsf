package br.edu.ifpb.pweb2.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.jboss.logging.Logger;

import br.edu.ifpb.pweb2.model.Especialidade;

public class EspecialidadeDAO extends GenericDAOJPAImpl<Especialidade, Long>  {
	
	private static Logger logger = Logger.getLogger(EspecialidadeDAO.class);
	
	public EspecialidadeDAO() {}
	
	public EspecialidadeDAO(EntityManager em) {
		super(em); 
	}
	
	@SuppressWarnings("unchecked")
	public List<Especialidade> findAllFromEspecialidade(Especialidade especialidade) {
		Query q = entityManager.createQuery("from Especialidade e where e.especialidade = :especialidade");
		q.setParameter("especialidade", especialidade);
		return q.getResultList();
	}

}
