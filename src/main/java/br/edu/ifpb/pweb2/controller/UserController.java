package br.edu.ifpb.pweb2.controller;

import java.io.Serializable;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import br.edu.ifpb.pweb2.dao.Transactional;
import br.edu.ifpb.pweb2.dao.UserDAO;
import br.edu.ifpb.pweb2.model.Admin;
import br.edu.ifpb.pweb2.model.Empresa;
import br.edu.ifpb.pweb2.model.User;
import br.edu.ifpb.pweb2.model.UsuarioDecorator;

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
	public void createUser(String nome, String phone,String email,String senha,String date) {
		User user = new User();
		user.setNome(nome);
		user.setTelefone(phone);
		user.setEmail(email);
		user.setSenha(senha);
		//user.setDatanascimento(new Date("01/12/1993"));
		userDAO.beginTransaction();
		userDAO.insert(user);
		userDAO.commit();
	}

}
