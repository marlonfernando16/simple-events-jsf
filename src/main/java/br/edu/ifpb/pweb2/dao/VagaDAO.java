package br.edu.ifpb.pweb2.dao;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;

import br.edu.ifpb.pweb2.model.Especialidade;
import br.edu.ifpb.pweb2.model.Vaga;

public class VagaDAO extends GenericDAOJPAImpl<Vaga, Long>  {
	private static Logger logger = Logger.getLogger(EspecialidadeDAO.class);
	
	public VagaDAO() {};
	
	public VagaDAO(EntityManager em) {
		super(em); 
	}
	

}
