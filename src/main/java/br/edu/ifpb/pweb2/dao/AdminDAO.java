package br.edu.ifpb.pweb2.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.jboss.logging.Logger;

import br.edu.ifpb.pweb2.model.Admin;
import br.edu.ifpb.pweb2.model.User;

public class AdminDAO extends GenericDAOJPAImpl<Admin, Long> {
	private static Logger logger = Logger.getLogger(AdminDAO.class);
	
	public AdminDAO() {}
	
	public AdminDAO(EntityManager em) {
		super(em); 
	}
	
	public Admin findByLogin(String login) {
		Query q = entityManager.createQuery("select admin from Admin admin where admin.email = :login");
		q.setParameter("login", login);
		Admin admin = null;
		try {
			admin = (Admin) q.getSingleResult();
		}catch (NoResultException e) {	
			return null;
		}
		return admin; 
	}

}
