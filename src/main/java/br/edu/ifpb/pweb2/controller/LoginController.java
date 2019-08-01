package br.edu.ifpb.pweb2.controller;

import java.io.Serializable;

import javax.inject.Inject;

import br.edu.ifpb.pweb2.dao.UserDAO;
import br.edu.ifpb.pweb2.model.User;

public class LoginController implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private UserDAO userDAO;
	
	public User isValido(String usuario, String senha) {

		User user = userDAO.findByLogin(usuario);
		if (user == null || !senha.equals(user.getSenha())) {
			user = null;
		}

		return user;
	}
}

