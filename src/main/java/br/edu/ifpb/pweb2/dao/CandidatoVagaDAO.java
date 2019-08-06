package br.edu.ifpb.pweb2.dao;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;

import br.edu.ifpb.pweb2.model.CandidatoVaga;

public class CandidatoVagaDAO extends GenericDAOJPAImpl<CandidatoVaga, Long>   {
	
	private static Logger logger = Logger.getLogger(CandidatoVagaDAO.class);
	
	CandidatoVagaDAO(){};
	
	public CandidatoVagaDAO(EntityManager em) {
		super(em); 
	}	
	

}
