package br.edu.ifpb.pweb2.controller;

import java.io.Serializable;
import java.util.Date;

import javax.inject.Inject;

import br.edu.ifpb.pweb2.dao.AdminDAO;
import br.edu.ifpb.pweb2.dao.Transactional;
import br.edu.ifpb.pweb2.model.Admin;
import br.edu.ifpb.pweb2.model.User;

public class AdminController implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	AdminDAO adminDAO;
	
	AdminController(){};
	
	public Admin find(long id) {
		return adminDAO.find(id);
	}
	
	@Transactional
	public Admin createAdmin(String nome, String phone,String email,String senha,Date date) {
		User usuario = adminDAO.findByLogin(email);
		if(usuario != null) {
			return null;
		}
		Admin admin = new Admin();
		admin.setNome(nome);
		admin.setTelefone(phone);
		admin.setEmail(email);
		admin.setSenha(senha);
		admin.setDatanascimento(date);
		adminDAO.beginTransaction();
		adminDAO.insert(admin);
		adminDAO.commit();
		System.out.println("ahhhhhh");
		return admin;
	}
	
	
}


