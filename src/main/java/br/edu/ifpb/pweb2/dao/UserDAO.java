package br.edu.ifpb.pweb2.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.jboss.logging.Logger;
import br.edu.ifpb.pweb2.model.User;

public class UserDAO extends GenericDAOJPAImpl<User, Long>  {
	
	private static Logger logger = Logger.getLogger(UserDAO.class);
	
	public UserDAO() {}
	
	public UserDAO(EntityManager em) {
		super(em); 
	}	
	
	public User findByLogin(String login) {
		Query q = entityManager.createQuery("select u from User u where u.email = :login");
		q.setParameter("login", login);
		User u = null;
		try {
			u = (User) q.getSingleResult();
		}catch (NoResultException e) {		
		}
		return u; 
	}
	

}
