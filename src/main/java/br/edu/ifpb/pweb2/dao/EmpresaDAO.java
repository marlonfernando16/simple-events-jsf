package br.edu.ifpb.pweb2.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.jboss.logging.Logger;

import br.edu.ifpb.pweb2.model.Admin;
import br.edu.ifpb.pweb2.model.Empresa;

public class EmpresaDAO extends GenericDAOJPAImpl<Empresa, Long> {
	private static Logger logger = Logger.getLogger(EmpresaDAO.class);
	
	public EmpresaDAO() {}
	
	public EmpresaDAO(EntityManager em) {
		super(em); 
	}
	
	
	
//	public Empresa findByLogin(String login) {
//		//Query q = entityManager.createQuery("select e from Empresa e where e.user.email = :login");
//		Query q = 
//		q.setParameter("login", login);
//		Empresa empresa= null;
//		try {
//			empresa = (Empresa) q.getSingleResult();
//		}catch (NoResultException e) {	
//			return null;
//		}
//		return empresa; 
//	}

}
