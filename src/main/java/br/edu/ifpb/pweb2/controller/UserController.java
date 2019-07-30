package br.edu.ifpb.pweb2.controller;

import java.io.Serializable;
import java.util.Date;

import javax.inject.Inject;

import br.edu.ifpb.pweb2.dao.Transactional;
import br.edu.ifpb.pweb2.dao.UserDAO;
import br.edu.ifpb.pweb2.model.User;

public class UserController implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	UserDAO userDAO;
	
	UserController(){};
	
	@Transactional
	public void createUser(String nome, String phone,String email,String senha,String date) {
		System.out.println("oiiiiii");
		
		User user = new User();
		user.setNome(nome);
		user.setTelefone(phone);
		user.setEmail(email);
		user.setSenha(senha);
		user.setDatanascimento(new Date("01/12/1993"));
		userDAO.beginTransaction();
		userDAO.insert(user);
		userDAO.commit();
	}

}
