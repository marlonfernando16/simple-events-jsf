package br.edu.ifpb.pweb2.controller;

import java.io.Serializable;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import br.edu.ifpb.pweb2.dao.Transactional;
import br.edu.ifpb.pweb2.dao.UserDAO;
import br.edu.ifpb.pweb2.model.User;

public class UserController implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	UserDAO userDAO;
	
	UserController(){};
	
	@PostConstruct
	private void init() {
		System.out.println("No Controller:"+userDAO);
	}
	
	@Transactional
	public User createUser(String nome, String phone,String email,String senha,Date date) {
		User usuario = userDAO.findByLogin(email);
		if(usuario != null) {
			return null;
		}
		User user = new User();
		user.setNome(nome);
		user.setTelefone(phone);
		user.setEmail(email);
		user.setSenha(senha);
		user.setDatanascimento(date);
		userDAO.beginTransaction();
		userDAO.insert(user);
		userDAO.commit();
		return user;
	}

	public User find(Long id_user) {
		return userDAO.find(id_user);
	}
	
}
