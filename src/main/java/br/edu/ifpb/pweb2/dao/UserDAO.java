package br.edu.ifpb.pweb2.dao;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;

import br.edu.ifpb.pweb2.model.User;

public class UserDAO extends GenericDAOJPAImpl<User, Long>  {
	private static Logger logger = Logger.getLogger(UserDAO.class);
	
	public UserDAO() {}
	
	public UserDAO(EntityManager em) {
		super(em); 
	}

}
