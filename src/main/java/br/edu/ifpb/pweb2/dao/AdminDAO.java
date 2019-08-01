package br.edu.ifpb.pweb2.dao;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;

import br.edu.ifpb.pweb2.model.Admin;

public class AdminDAO extends GenericDAOJPAImpl<Admin, Long> {
	private static Logger logger = Logger.getLogger(AdminDAO.class);
	
	public AdminDAO() {}
	
	public AdminDAO(EntityManager em) {
		super(em); 
	}

}
