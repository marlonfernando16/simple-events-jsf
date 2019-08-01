package br.edu.ifpb.pweb2.dao;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;

import br.edu.ifpb.pweb2.model.Empresa;

public class EmpresaDAO extends GenericDAOJPAImpl<Empresa, Long> {
	private static Logger logger = Logger.getLogger(EmpresaDAO.class);
	
	public EmpresaDAO() {}
	
	public EmpresaDAO(EntityManager em) {
		super(em); 
	}

}
